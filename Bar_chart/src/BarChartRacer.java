import java.util.ArrayList;
import java.util.List;

public class BarChartRacer {
    public static void main(String[] args) {
        String filename = args[0]; // Adjust the path to your data file

        // Read the entire input from file
        In in = new In(filename);
        List<String> lines = new ArrayList<>();
        while (!in.isEmpty()) {
            lines.add(in.readLine());
        }
        String[] inputLines = lines.toArray(new String[0]);

        // Initialize variables to store title, x-axis label, and source
        String title = inputLines[0];
        String xAxisLabel = inputLines[1];
        String source = inputLines[2];

        // Create an empty list to hold all the data records
        List<BarChart> charts = new ArrayList<>();

        // Process each year's data
        int index = 3; // Start from the line after source
        while (index < inputLines.length) {
            String line = inputLines[index++].trim();
            if (line.isEmpty()) {
                continue; // Skip empty lines
            }

            // Read number of records for this year
            int numberOfRecords = Integer.parseInt(line);

            // Create a new BarChart instance for each year
            BarChart chart = new BarChart(title, xAxisLabel, source);

            // Process each record for the current year
            for (int i = 0; i < numberOfRecords; i++) {
                String recordLine = inputLines[index++].trim();
                String[] parts = recordLine.split(",");

                int year = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String country = parts[2].trim();
                int population = Integer.parseInt(parts[3].trim());
                String category = parts[4].trim();

                // Create a Bar instance and add it to the chart
                Bar bar = new Bar(name, population, category);
                chart.add(bar.getName(), bar.getValue(), bar.getCategory());
            }

            // Set the caption for the chart to the current year
            chart.setCaption("Year " + (charts.size() + 1500)); // Index starts from 0

            // Add the created chart to the list
            charts.add(chart);
        }

        // Display the charts one by one
        for (BarChart chart : charts) {
            StdDraw.setCanvasSize(1000, 700);
            StdDraw.enableDoubleBuffering();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100); // Short pause between frames
            StdDraw.clear();
        }
    }
}
