package org.abhishek.advenofcode2022.dayeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class DayEightMain {
	
	private final String fileName;
	
	public DayEightMain(String fileName) {
		this.fileName = fileName;
	}

	public static void main(String[] args) {
		//DayEightMain main = new DayEightMain("SampleInput.txt");
		DayEightMain main = new DayEightMain("RealInput.txt");
		
		int[][] matrixFromFile = main.create2DArrayFromFile();
		//System.out.println("Number of Edge Elements: " + main.getNumOfEdgeElements(matrixFromFile));
		//main.analyseVisibility(matrixFromFile);
		//Part 1
		int countOfVisibleTrees = main.getCountOfVisibleTrees(matrixFromFile);
		System.out.println("Final free: " + countOfVisibleTrees);
		//Part 1
		
		//Part 2
		int maxScenicScore = main.findMaxScenicScore(matrixFromFile);
		System.out.println(maxScenicScore);
		//Part 2
	}
	
	public int findMaxScenicScore(int[][] treeMatrix) {
		int maxScore = 0;
		List<Integer> scenicScores = new ArrayList<>();
		for(int i = 0; i < treeMatrix.length; i++) {
			List<Integer> scoreForRow = findScenicScoreForRow(i, treeMatrix);
			scenicScores.addAll(scoreForRow);
		}
		maxScore = scenicScores.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(-1);
		return maxScore;
	}
	
	public int calculateViewingDistanceTowardsTop(int row, int col, int[][] treeMatrix) {
		int viewingDistance = 0;
		if(row == 0) {
			viewingDistance = 0;
		} else {
			int tempRow = row - 1;
			while(tempRow > -1) {
				if(treeMatrix[tempRow][col] >= treeMatrix[row][col]) {
					viewingDistance++;
					break;
				} else {
					viewingDistance++;
				}
				tempRow--;
			}
		}
		return viewingDistance;
	}
	
	public int calculateViewingDistanceTowardsBottom(int row, int col, int[][] treeMatrix) {
		int viewingDistance = 0;
		if(row == treeMatrix.length - 1) {
			viewingDistance = 0;
		} else {
			int tempRow = row + 1;
			while(tempRow < treeMatrix.length) {
				if(treeMatrix[tempRow][col] >= treeMatrix[row][col]) {
					viewingDistance++;
					break;
				} else {
					viewingDistance++;
				}
				tempRow++;
			}
		}
		return viewingDistance;
	}
	
	public int calculateViewingDistanceTowardsLeft(int row, int col, int[][] treeMatrix) {
		int viewingDistance = 0;
		if(col == 0) {
			viewingDistance = 0;
		} else {
			int tempCol = col - 1;
			while(tempCol > - 1) {
				if(treeMatrix[row][tempCol] >= treeMatrix[row][col]) {
					viewingDistance++;
					break;
				} else {
					viewingDistance++;
				}
				tempCol--;
			}
		}
		return viewingDistance;
	}
	
	public int calculateViewingDistanceTowardsRight(int row, int col, int[][] treeMatrix) {
		int viewingDistance = 0;
		if(col == treeMatrix[0].length - 1) {
			viewingDistance = 0;
		} else {
			int tempCol = col + 1;
			while(tempCol < treeMatrix[0].length) {
				if(treeMatrix[row][tempCol] >= treeMatrix[row][col]) {
					viewingDistance++;
					break;
				} else {
					viewingDistance++;
				}
				tempCol++;
			}
		}
		return viewingDistance;
	}
	
	public List<Integer> findScenicScoreForRow (int rowIndex, int[][] treeMatrix) {
		int[] row = treeMatrix[rowIndex];
		System.out.println(Arrays.toString(row));
		List<Integer> scenicScores = new ArrayList<>();
		for(int i = 0; i < row.length; i++) {
			int viewingDistanceTowardsTop = calculateViewingDistanceTowardsTop(rowIndex, i, treeMatrix);
			int viewingDistanceTowardsBottom = calculateViewingDistanceTowardsBottom(rowIndex, i, treeMatrix);
			int viewingDistanceTowardsLeft = calculateViewingDistanceTowardsLeft(rowIndex, i, treeMatrix);
			int viewingDistanceTowardsRight = calculateViewingDistanceTowardsRight(rowIndex, i, treeMatrix);
			scenicScores.add(viewingDistanceTowardsTop * viewingDistanceTowardsBottom * viewingDistanceTowardsLeft * viewingDistanceTowardsRight);
			//System.out.println(treeMatrix[rowIndex][i] + "->" + viewingDistanceTowardsBottom);
		}
		return scenicScores;
	}

	//Part 1
	private int getCountOfVisibleTrees( int[][] matrixFromFile) {
		int visibleTrees = 0;
		for(int i = 0; i < matrixFromFile.length; i++) {
			visibleTrees = visibleTrees + analyseRowForVisibility(i, matrixFromFile);
		}
		//System.out.println("Final free: " + visibleTrees);
		return visibleTrees;
	}
	
	public int[][] create2DArrayFromFile() {
		FileReader reader = new FileReader(fileName);
		List<String> lines = reader.readLines();
		int[][] treeMatrix = prepareMatrix(lines);
		return treeMatrix;
	}

	private int[][] prepareMatrix(List<String> lines) {
		int rowCnt = lines.size();
		int colCnt = lines.get(0).length();
		
		
		int[][] treeMatrix = new int[rowCnt][colCnt];
		for(int i = 0; i < rowCnt; i++) {
			for(int j = 0; j < colCnt; j++) {
				treeMatrix[i][j] = lines.get(i).charAt(j) - '0';	//without '0' it will print Unicode code point for the character
			}
		}
		//diaplayMatrix(treeMatrix);
		return treeMatrix;
	}

	//method to print a 2D array
	private void diaplayMatrix(int[][] treeMatrix) {
        for (int[] arr : treeMatrix) {
            System.out.println(Arrays.toString(arr));
        }
	}
	
	//count number of edge elements in the matrix
	public int getNumOfEdgeElements(int[][] treeMatrix) {
		int rows = treeMatrix.length;
		int columns = treeMatrix[0].length;
		int edgeElementsCnt = (rows * 2) + ((columns - 2) * 2);
		return edgeElementsCnt;
	}
	
	public boolean isElementVisibleFromLeft(int row, int col, int[][] treeMatrix) {
		boolean isVisible = true;
		if(col == 0) {
			isVisible = true;
		} else {
			int tempCol = col - 1;
			while(tempCol > - 1) {
				if(treeMatrix[row][tempCol] >= treeMatrix[row][col]) {
					isVisible = false;
					break;
				}
				tempCol--;
			}
		}
		return isVisible;
	}
	
	public boolean isElementVisibleFromRight(int row, int col, int[][] treeMatrix) {
		boolean isVisible = true;
		if(col == treeMatrix[0].length - 1) {
			isVisible = true;
		} else {
			int tempCol = col + 1;
			while(tempCol < treeMatrix[0].length) {
				if(treeMatrix[row][tempCol] >= treeMatrix[row][col]) {
					isVisible = false;
					break;
				} 
				tempCol++;
			}
		}
		return isVisible;
	}
	
	public boolean isElementVisibleFromTop(int row, int col, int[][] treeMatrix) {
		boolean isVisible = true;
		if(row == 0) {
			isVisible = true;
		} else {
			int tempRow = row - 1;
			while(tempRow > -1) {
				if(treeMatrix[tempRow][col] >= treeMatrix[row][col]) {
					isVisible = false;
					break;
				} 
				tempRow--;
			}
		}
		return isVisible;
	}
	
	public boolean isElementVisibleFromBottom(int row, int col, int[][] treeMatrix) {
		boolean isVisible = true;
		if(row == treeMatrix.length - 1) {
			isVisible = true;
		} else {
			int tempRow = row + 1;
			while(tempRow < treeMatrix.length) {
				if(treeMatrix[tempRow][col] >= treeMatrix[row][col]) {
					isVisible = false;
					break;
				} 
				tempRow++;
			}
		}
		return isVisible;
	}
	
	public int analyseVisibility(int[][] treeMatrix) {
		int visibleCnt = 0;
		for(int i = 0; i < treeMatrix.length; i++) {
			for(int j = 0; j < treeMatrix[0].length; i++) {
				boolean isVisibleFromBottom = isElementVisibleFromBottom(i, j, treeMatrix);
				boolean isVisibleFromTop = isElementVisibleFromTop(i, j, treeMatrix);
				boolean isVisibleFromLeft = isElementVisibleFromLeft(i, j, treeMatrix);
				boolean isVisibleFromRight = isElementVisibleFromRight(i, j, treeMatrix);
				if(isVisibleFromBottom || isVisibleFromTop || isVisibleFromLeft || isVisibleFromRight) {
					visibleCnt++;
				}
			}
		}
		System.out.println("Number of elements visible is: " + visibleCnt);
		return visibleCnt;
	}
	
	public int analyseRowForVisibility (int rowIndex, int[][] treeMatrix) {
		int[] row = treeMatrix[rowIndex];
		int visibleCnt = 0;
		for(int i = 0; i < row.length; i++) {
			boolean isVisibleFromBottom = isElementVisibleFromBottom(rowIndex, i, treeMatrix);
			boolean isVisibleFromTop = isElementVisibleFromTop(rowIndex, i, treeMatrix);
			boolean isVisibleFromLeft = isElementVisibleFromLeft(rowIndex, i, treeMatrix);
			boolean isVisibleFromRight = isElementVisibleFromRight(rowIndex, i, treeMatrix);
			
			if(isVisibleFromBottom || isVisibleFromTop || isVisibleFromLeft || isVisibleFromRight) {
				visibleCnt++;
			}
		}
		//System.out.println("Row index: '" + rowIndex + "' ananlysed. Row is: " + Arrays.toString(row));
		//System.out.println("Number of elements visible is: " + visibleCnt);
		return visibleCnt;
	}
	
	public int analyseRowForVisibility_Old_Working (int rowIndex, int[][] treeMatrix) {
		int[] row = treeMatrix[rowIndex];
		int visibleCnt = 0;
		for(int i = 0; i < row.length; i++) {
			boolean isVisible = isElementVisibleFromBottom(rowIndex, i, treeMatrix);
			if(isVisible) {
				visibleCnt++;
			}
			System.out.println(treeMatrix[rowIndex][i] + "->" + isVisible);
		}
		System.out.println("Row ananlysed: " + Arrays.toString(row));
		System.out.println("Number of elements visible from top is: " + visibleCnt);
		return visibleCnt;
	}
	

}
