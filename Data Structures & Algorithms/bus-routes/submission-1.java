class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // bus stops as nodes

        // bfs by level(stops on the same bus route), see what is the minimum bus taken

        // do not want to hop backon the same bus, so we using visitSet for bus

        // how to record

        // stuck:
        //     how to bfs traverse the bus routes, if I want to treat each bus route as an level?

            // add(1)  map: 1: 0
            //     add(1), visited so no
            //     add (2), !visited yes
            //     add ()
            // add (7)   map: 7: [0, 1]

            // for (int bus: map.get(stop)){
            //     if (visitBus[bus])continue;
            //     for ()
            // }
        
        if (source == target) return 0;
        Set<Integer> visitBus = new HashSet<>();
        Set<Integer> visitStop = new HashSet<>();
        Map<Integer, List<Integer>> stopToBus = new HashMap<>();
        for (int i = 0; i < routes.length; i++){
            for (int j = 0; j < routes[i].length; j++){
                int stop = routes[i][j];
                stopToBus.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }
        if (!stopToBus.containsKey(source) ||!stopToBus.containsKey(target) )return -1;
        int buses = 0;
        visitStop.add(source);
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                int stop = q.poll();
                if (stop == target) return buses;
                for (int bus: stopToBus.get(stop)){
                    if (visitBus.contains(bus)) continue;
                    visitBus.add(bus);
                    for (int newStop: routes[bus]){
                        if (visitStop.contains(newStop)) continue;
                        visitStop.add(newStop);
                        q.add(newStop);
                    }
                }
            }
            buses++;
        }
        return -1;
        
    }
}