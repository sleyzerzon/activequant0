/****

    activequant - activestocks.eu

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.

	
	contact  : contact@activestocks.eu
    homepage : http://www.activestocks.eu

****/
package org.activequant.util.tools;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @TODO desc<br>
 * <br>
 * <b>History:</b><br>
 *  - [11.06.2007] Created (Erik Nijkamp)<br>
 *  - [11.06.2007] Added converters, dumper (Ulrich Staudinger)<br>
 *
 *  @author Erik Nijkamp
 *  @author Ulrich Staudinger
 */
public class Arrays {
	
	@SuppressWarnings("unchecked")
	public static <T> T[] asArray(final Collection<T> list, Class<T> clazz) {
		T[] emptyArray = (T[]) Array.newInstance(clazz, 0);
		return list == null ? emptyArray : list.toArray(emptyArray);
	}
	
	public static <T> List<T> asList(final T[] array) {
		return array == null ? new ArrayList<T>() : new ArrayList<T>(java.util.Arrays.asList(array));
	}
	
	public static <T> void reverse(T[] b) {
		for (int left = 0, right = b.length - 1; left < right; left++, right--) {
			// exchange the first and last
			T temp = b[left];
			b[left] = b[right];
			b[right] = temp;
		}
	}
	
	public static void reverse(double[] b) {
		for (int left = 0, right = b.length - 1; left < right; left++, right--) {
			// exchange the first and last
			double temp = b[left];
			b[left] = b[right];
			b[right] = temp;
		}
	}
	
    public static String toString(Object[] input){
        StringBuilder ret = new StringBuilder();
        for(Object o : input){
            ret.append("[");
            ret.append(o);
            ret.append("] ");
        }
        return ret.toString();
    }
    
    public static String toString(Object[][] input){
        StringBuilder ret = new StringBuilder();
        for(Object[] o : input){
            ret.append(toString(o));
            ret.append("\n");
        }
        return ret.toString();
    }
	public static double[] convert(Collection<Double> list) {
		return convert(list.toArray(new Double[] {}));
	}
	
	public static double[] convert(Double[] in){
		double[] ret = new double[in.length];
		for(int i=0;i<in.length;i++){
			ret[i] = in[i];
		}
		return ret; 
	}
	
	public static Double[] convert(double[] in){
		Double[] ret = new Double[in.length];
		for(int i=0;i<in.length;i++){
			ret[i] = in[i];
		}
		return ret; 
	}
	
	public static double[][] convert(Double[][] in){
		double[][] ret = new double[in.length][in[0].length];
		for(int i=0;i<in.length;i++){
			for(int j = 0; j<in[0].length;j++){
				ret[i][j] = in[i][j];
			}
		}
		return ret; 
	}
}