# SmartDataSolution Assignment
---
---

# Member File Converter

This project is designed to import member information from a CSV file, process the data (such as removing duplicates and splitting the members by state), and export the members into separate CSV files based on their state.

## Project Structure

- **`Main.java`**: The main entry point of the application. This class contains the logic for orchestrating the file conversion process.
- **`MemberImporterImpl.java`**: Handles importing member data from a CSV file and converts each line into a `Member` object.
- **`MemberExporterImpl.java`**: Exports processed member data into separate CSV files by state.
- **`Member.java`**: The model class that represents a `Member` with fields such as `id`, `firstName`, `lastName`, `address`, `city`, `state`, and `zip`.
- **`MemberFileConverter.java`**: An abstract class that defines the blueprint for importing, processing, and exporting member data.

## Functionality

1. **Import Members**:
   - The members are imported from a CSV file using `MemberImporterImpl`.
   - Each line from the file represents a `Member` object with specific fields.

2. **Remove Duplicates**:
   - After importing the data, the program removes duplicate members based on their `id` using the `getNonDuplicateMembers` method.

3. **Split by State**:
   - The non-duplicate members are then grouped by state using the `splitMembersByState` method.

4. **Export Members**:
   - Finally, the `MemberExporterImpl` class writes the members into separate CSV files for each state.

## How to Run

1. Place the input CSV file in the project directory. The file should be formatted as follows:
   - Columns: `id`, `first name`, `last name`, `address`, `city`, `state`, `zip`
   - Make sure there is no duplicate member `id` within the file.

2. The main method is located in the `Main.java` file. Run the program from this file, and the program will:
   - Import members from the `inputFile.csv`.
   - Remove duplicates and group members by state.
   - Export the members to state-specific CSV files (e.g., `CA_members.csv`, `NY_members.csv`, etc.).

3. Review the output files in the project directory.

## Example Input File

```csv
id,first name,last name,address,city,state,zip
001,John,Doe,123 Main St,Los Angeles,CA,90001
002,Jane,Smith,456 Oak St,New York,NY,10001
003,Emily,Johnson,789 Pine St,Los Angeles,CA,90002
```

## Example Output Files

For the input file above, the program will generate two output files:
- **`CA_members.csv`**
- **`NY_members.csv`**

## Error Handling

The program catches `IOException` during file reading and writing operations and outputs an error message if something goes wrong.

## Requirements

- Java 8+
- The CSV file should be formatted properly with consistent column widths.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

---
