public static Integer[] mergeArrays(Integer[] a, Integer[] b){
	Integer[] c = new Integer[a.length + b.length];

	for(int i =0; i < c.length; i++){
		if(i < a.length){
			c[i] = a[i];
		}else{
			c[i] = b[i - a.length];
		}
	}

	return c;
}

public static Integer[] sortWithInsertionSort(Integer[] a){
	int temp;
	for(int i = 1; i < a.length; i++){
		for(int j = i; j > 0 && a[j-1] > a[j]; j--){
			temp = a[j];
			a[j] = a[j-1];
			a[j-1] = temp;
		}
	}

	return a;
}

	
public static Integer[] makeCommonArray(Integer[] a, Integer[] b){
	Integer[] mergedArray = mergeArrays(a,b);
	Integer[] sortedArray = sortWithInsertionSort(mergedArray);


	Integer[] commonElementsArray = new Integer[sortedArray.length];

	int previousElement = sortedArray[0];
	int commonElementsCount = 0;

	for(int i = 1, k = sortedArray.length; i < k; i++){
		if(previousElement == sortedArray[i]){
			if(commonElementsCount > 0 && commonElementsArray[commonElementsCount - 1] == sortedArray[i])
				continue;

			commonElementsArray[commonElementsCount] = sortedArray[i];
			commonElementsCount++;
		}
		previousElement = sortedArray[i];
	}

	Integer[] updatedCommonElementsArray = new Integer[commonElementsCount];
	for(int i = 0; i < commonElementsCount; i++){
		updatedCommonElementsArray[i] = commonElementsArray[i];
	}

	return updatedCommonElementsArray;
}
