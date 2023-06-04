
package question;

import java.io.*;
import java.util.*;


public class MarketNavigator
{  
	
	/* Method that gives the distance between two points */
	public static double distanceFinder(int x1, int y1, int x2, int y2) {
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}

	public static int pathFinder(String filename) {
		
		/* Find the smallestTotalDistance */
		double smallestTotalDistance = 0;
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		/*Ahmet Batuhan Canlý 2020400102 */
		/*reading the file*/
		try {
			BufferedReader reader= new BufferedReader(new FileReader(filename));
			String line=reader.readLine();
			ArrayList<String> listoflines=new ArrayList<>();
			while (line!=null) {
				listoflines.add(line);
				line=reader.readLine();	
			}
			reader.close();
			/*arraylist for store house objects*/
			ArrayList<House> houseObjects= new ArrayList<>();
			int whichHouse=0;
			ArrayList<Integer> indexOfHouses = new ArrayList<>();
			for (String houseData : listoflines) {
				String[] eachHouseData;
				eachHouseData=houseData.split(" ");
				/*creating house objects*/
				House pHouse= new House();
				pHouse.setName(eachHouseData[0]);
				pHouse.setX(Integer.valueOf(eachHouseData[1]));
				pHouse.setY(Integer.valueOf(eachHouseData[2]));
				houseObjects.add(whichHouse,pHouse);
				indexOfHouses.add(whichHouse);
				whichHouse++;
					
			}
			
			/* possiblePermutations stores all possible permutations for house object's indexes*/
			ArrayList<ArrayList<Integer>>possiblePermutations= new ArrayList<>();
			
			Permutation(indexOfHouses, 1, possiblePermutations);
			/* totalDistancesOfAllPermutations stores path values for each permutation*/
			ArrayList<Double>totalDistancesOfAllPermutations= new ArrayList<Double>();
			/*outer for loop to loop through possiblePermutations*/
			for (ArrayList<Integer> integers : possiblePermutations) {
				double totalDistancePerPermutation=0.0;
				/*inside for loop to loop through permutations and than get their x and y values and find the distance between two points*/
				for (int whichTowhich=0;whichTowhich<integers.size();whichTowhich++) {
					if (whichTowhich==integers.size()-1) {
						int x0=houseObjects.get(0).getX();
						int y0=houseObjects.get(0).getY();
						int lastx=houseObjects.get(integers.get(whichTowhich)).getX();
						int lasty=houseObjects.get(integers.get(whichTowhich)).getY();
						double distanceBetweenTwoL=distanceFinder(x0, y0, lastx, lasty);
						totalDistancePerPermutation=totalDistancePerPermutation+distanceBetweenTwoL;
						break;
					}
					int a=integers.get(whichTowhich);
					int b=integers.get(whichTowhich+1);
					int xa=houseObjects.get(a).getX();
					
					int xb=houseObjects.get(b).getX();
					
					int ya=houseObjects.get(a).getY();
					
					int yb=houseObjects.get(b).getY();
					
					double distanceBetweenTwo=distanceFinder(xa, ya, xb, yb);
					/*at the end of the loop distance between two points is added to total distance*/
					totalDistancePerPermutation=totalDistancePerPermutation+distanceBetweenTwo;	
				}
				totalDistancesOfAllPermutations.add(totalDistancePerPermutation);
				
			}
			/*smallestTotalDistance equals to min value of all possible permutation values*/
			smallestTotalDistance=Collections.min(totalDistancesOfAllPermutations);
			
			
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		



		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
		int roundedValue = (int) Math.round(smallestTotalDistance);
		return roundedValue;
		
	}

	public static void main(String[] args) {
		
		/* This part is for you to test your method, no points will be given from here */
		String path = MarketNavigator.class.getProtectionDomain().getCodeSource().getLocation().getPath() + File.separator + ".." + File.separator+"coordinates.txt";
		int distance = pathFinder("coordinates3.txt"); 
		System.out.println("Smallest distance:" + distance);
	}
	/* a functions finds all possible permutations recursively of given list and stores them in another arraylist*/
	public static void Permutation(ArrayList<Integer> sayilar,int currentýndex,ArrayList<ArrayList<Integer>> a) {
		if (currentýndex==sayilar.size()) {
			a.add((ArrayList<Integer>) sayilar.clone());
			
			return;
			
		}
		for (int i = currentýndex; i < sayilar.size(); i++) {
			Collections.swap(sayilar,i,currentýndex);
			Permutation(sayilar, currentýndex+1,a);
			Collections.swap(sayilar,i,currentýndex);
			
			
			
		}
		
		
	}
	
	
}  

