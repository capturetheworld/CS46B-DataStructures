package dna;

import java.io.*;


//
// Reads lines from a BufferedReader and builds a FastqReader.
//

public class FastqReader 
{
	BufferedReader theBufferedReader;
	
	//init
	public FastqReader(BufferedReader br) {
		theBufferedReader=br;
		
	}

	// Creates a FastqRecord from Fastqfile
	// else next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Read the defline from the BufferedReader. Return null if you read null, 
		// indicating end of file.
		
		String firstLine = theBufferedReader.readLine();
		String secondLine;
		String fourthLine;
		
		if(firstLine == null) {
			return null; //EOF
		}
		else { //constructs a record
			secondLine =theBufferedReader.readLine();
			theBufferedReader.readLine();
			fourthLine =theBufferedReader.readLine();
			
			return new FastqRecord(firstLine,secondLine,fourthLine);
		}
		
	}
	
}

