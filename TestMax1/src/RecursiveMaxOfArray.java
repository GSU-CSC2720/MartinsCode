
/**
 * Use a double recursion to compute the maximum of an array of values.
 * 

 */
public class RecursiveMaxOfArray
{

    
    /**
     * Compute the maximum of a range of values in an array recursively.
     *
     * @param data   An array of integers.
     * @param from  The low index for searching for the maximum.
     * @param to    The high index for searching for the maximum.
     * 
     * preconditions: from <= to, from >=0, to<length, length>0
     *                
     * @return     The maximum value in the array.
     */
    
    public  int max(int data[], int from, int to)
    {
        int result = 0;
        if(data == null)
        {
            throw new BadArgumentsForMaxException("null");
        }
        if(data.length == 0 || from < 0 || to >= data.length || from > to)
        {
            throw new BadArgumentsForMaxException("It's either empty, less than, or greater than bruh");
        }
        if(from == to)
        {
            return data[from];
        }
        int mid = (from + to) / 2;
        int max1 = max(data,from, mid);
        int max2 = max(data,mid+1, to);
        result = Math.max(max1,max2);
        return result;
    }
    
    
}
