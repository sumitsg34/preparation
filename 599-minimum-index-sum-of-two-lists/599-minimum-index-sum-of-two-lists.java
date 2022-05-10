class Solution {
    
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String,Integer> hotels = new HashMap<>();
        
        for(int i = 0; i < list1.length; i++ ) {
            hotels.put(list1[i], i);
        }
        
        List<String> commonHotels = new ArrayList<>();
        Integer indexSum = 100000;
        
        for(int i = 0; i < list2.length; i++ ) {
            if(hotels.containsKey(list2[i])) {
                
                if( (i+ hotels.get(list2[i])) == indexSum) {
                    indexSum = i + hotels.get(list2[i]);
                    commonHotels.add(list2[i]);
                }else if ( (i + hotels.get(list2[i])) < indexSum) {
                    indexSum = i + hotels.get(list2[i]);
                    commonHotels = new ArrayList<>();
                    commonHotels.add(list2[i]);
                }
            }
        }
        String[] out = new String[commonHotels.size()];
        return commonHotels.toArray(out);
                  
    }
}