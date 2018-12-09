package class13;

public class DoubleSelectionHandle implements SortHandle{
	double[] array;
	
	public void swap(int index1,int index2) {
		double temp=array[index1];
		array[index1]=array[index2];
		array[index2]=temp;
	}
	
	public int findthemin(int index) {
		int min=index;
		for(int i=index+1;i<array.length;i++){
		if(array[i]<array[min]){
			min=i;
		}
	}
		return min;
	} 
	
	public int length() {
		return array.length;
	}

	public void setArray(Object Array) {
		// TODO Auto-generated method stub

		array=(double[])Array;
	} 
	
	
	public void showout() {
		// TODO Auto-generated method stub
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
			}
}
}

