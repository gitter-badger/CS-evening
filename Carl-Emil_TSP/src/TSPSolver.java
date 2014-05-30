public class TSPSolver {

    public static void main(String[] args) {

        int w = 9;
        int h = 9;
        int size = 4;

        int[] data = RandomData.getRandomData(size, w, h, 0);
        data = TSPTools.readGraphFromCVSFile("../nodegen/10_locations.csv");

        int[][] distanceArray = DistanceArray.getArray(data, w, h);

        System.out.println(" - Distance array - ");
        for (int i = 0; i < data.length / 2; i++) {
            for (int j = 0; j < data.length / 2; j++) {
                System.out.print(" " + distanceArray[i][j]);
            }
            System.out.println();
        }

        int[] path = new int[size];

        for (int i = 0; i < size; i++) {
            path[i] = i;
        }

        long length = TSPTools.getPathLength(distanceArray, path);

        boolean valid = TSPTools.isPathValid(path);

        System.out.println("This TSP path is " + length + " km long and is "
                + (valid ? "valid" : "invalid"));


        TSPTools.printPath(path);
    }

}
