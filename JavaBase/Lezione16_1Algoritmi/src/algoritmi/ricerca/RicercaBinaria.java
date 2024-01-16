package algoritmi.ricerca;

/*
FUNCTION binary_search ( array , start , end , x )

	WHILE start < end DO

		mid := ( start + end ) / 2

		IF x == array[mid] THEN
			RETURN mid
		ELSE IF x > array[mid] THEN
			RETURN binary_search( array , mid + 1 , end , x )
		ELSE
			RETURN binary_search( array , start , mid - 1 , x )

	END WHILE

END FUNCTION
 */
public class RicercaBinaria {

    public int lunghezzaArray;

    public int RecursiveBinarySearch(int[] array, int key, int start, int end) {
        lunghezzaArray = array.length;
        int mid = start + (end - start)/2;
        if(end >= start){
            if (array[mid] == key) return mid;
            if (key > array[mid]) return RecursiveBinarySearch(array,key,mid+1,end);
            else return RecursiveBinarySearch(array,key,start,mid-1);
        }
        return -1;
    }

    public int IterativeBinarySearch(int[] array, int key) {
        int start = 0;
        int end = array.length -1;
        int mid;
        while(start <= end) {
            mid = start + (end - start)/2;
            if (array[mid] == key) return mid;
            if (array[mid] > key) end = mid-1;
            else start = mid + 1;
        }
        return -1;
    }

}
