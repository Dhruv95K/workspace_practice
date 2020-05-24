package binarySearch;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/*
497. Random Point in Non-overlapping Rectangles
Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly 
and uniformily picks an integer point in the space covered by the rectangles.

Note:
	1. An integer point is a point that has integer coordinates. 
	2. A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
	3.ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the 
		bottom-left corner, and [x2, y2] are the integer coordinates of the top-right corner.
	4. length and width of each rectangle does not exceed 2000.
	5. 1 <= rects.length <= 100
	6. pick return a point as an array of integer coordinates [p_x, p_y]
	7. pick is called at most 10000 times.

Example 1:
	Input: 
	["Solution","pick","pick","pick"]
	[[[[1,1,5,5]]],[],[],[]]
	Output: 
	[null,[4,1],[4,1],[3,3]]
			
Example 2:
	Input: 
	["Solution","pick","pick","pick","pick","pick"]
	[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
	Output: 
	[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
	Explanation of Input Syntax:
	
	The input is two lists: the subroutines called and their arguments. Solution's 
	constructor has one argument, the array of rectangles rects. pick has no arguments. 
	Arguments are always wrapped with a list, even if there aren't any.
*/

public class RandomPointInNonOverlappingRectangles497 {
	int[][] rects;
	Random random;
	TreeMap<Integer, Integer> map;
	int sum = 0;

	public RandomPointInNonOverlappingRectangles497(int[][] rects) {
		this.random = new Random();
		this.rects = rects;
		this.map = new TreeMap<Integer, Integer>();
		sum = 0;

		for (int i = 0; i < rects.length; i++) {
			sum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
			map.put(sum, i);
		}

	}

	public int[] pick() {
		int s = map.ceilingKey(random.nextInt(sum) + 1);
		int indx = map.get(s);

		int left = rects[indx][0], right = rects[indx][0], bottom = rects[indx][1], top = rects[indx][3];

		int x = left + random.nextInt(right - left + 1);
		int y = bottom + random.nextInt(top - bottom + 1);
		
		return new int[] {x,y};
	}
}
