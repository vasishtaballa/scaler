package com.scaler.academy.assignment.sep17;

public class RainwaterTrap {
	public static void main(String[] args) {
		RainwaterTrap obj = new RainwaterTrap();
		int[] array = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		obj.trap(array);
	}

	public int trap(final int[] A) {
		int[] leftMax = new int[A.length];
		int[] rightMax = new int[A.length];
		getLeftAndRightMax(A, leftMax, rightMax);
		int result = 0;
		System.out.println("Left Max: ");
		for (int i = 0; i < leftMax.length; i++) {
			System.out.print(leftMax[i] + " ");
		}
		System.out.println("Right Max: ");
		for (int i = 0; i < rightMax.length; i++) {
			System.out.print(rightMax[i] + " ");
		}
		for (int i = 0; i < A.length; i++)
			result += Math.min(leftMax[i], rightMax[i]) - A[i];
		return result;
	}

	public void getLeftAndRightMax(int[] array, int[] leftMax, int[] rightMax) {
		leftMax[0] = array[0];
		rightMax[array.length - 1] = array[array.length - 1];
		for (int i = 1, j = array.length - 2; i < array.length && j >= 0; i++, j--) {
			leftMax[i] = leftMax[i - 1] >= array[i] ? leftMax[i - 1] : array[i];
			rightMax[j] = rightMax[j + 1] >= array[j] ? rightMax[j + 1] : array[j];
		}
	}
}
