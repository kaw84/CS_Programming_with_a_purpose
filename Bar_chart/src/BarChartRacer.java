import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BarChartRacer {
    public static void main(String[] args) {
        String filename = args[0]; // Filename from the command line argument
        int k = Integer.parseInt(args[1]); // Number of bars to display

        // Open the input file
        In in = new In(filename);

        // Read title, x-axis label, and source
        String title = in.readLine();
        String xAxisLabel = in.readLine();
        String source = in.readLine();

        // Create a single BarChart object
        BarChart chart = new BarChart(title, xAxisLabel, source);

        // Enable double buffering for smoother animation
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        // Process the input file line by line
        while (in.hasNextLine()) {
            String line = in.readLine();
            if (line.isEmpty()) {
                continue;
            }

            // Read number of records for this year
            int numberOfRecords = Integer.parseInt(line);

            // List to store the bars
            List<Bar> bars = new ArrayList<>();

            // Process each record for the current year
            String year = "";
            for (int i = 0; i < numberOfRecords; i++) {
                line = in.readLine();
                String[] parts = line.split(",");
                year = parts[0].trim(); // Capture the year from the first record
                String name = parts[1].trim();
                int value = Integer.parseInt(parts[3].trim());
                String category = parts[4].trim();

                // Add the bar to the list
                bars.add(new Bar(name, value, category));
            }

            // Sort the bars in descending order of value
            Collections.sort(bars, Collections.reverseOrder());

            // Reset the chart for the new year
            chart.reset();

            // Add top k bars to the chart
            for (int i = 0; i < Math.min(k, bars.size()); i++) {
                Bar bar = bars.get(i);
                chart.add(bar.getName(), bar.getValue(), bar.getCategory());
            }

            // Set the caption for the chart to the current year
            chart.setCaption(year);

            // Draw the chart
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100); // Pause to control animation speed
        }
    }
}
