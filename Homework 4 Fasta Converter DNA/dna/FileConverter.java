package dna;

import java.io.*;
import java.util.*;


public class FileConverter {
	File fastq;
	File fasta;

	public FileConverter(File fastq, File fasta) {
		this.fastq = fastq;
		this.fasta = fasta;
	}
  //Connected the reader/writer chain together so that all methods are accessible on the files
	public void convert() throws IOException {	
		//Chain of readers.
		FileReader fr = new FileReader(fastq); //opens passed in file
		BufferedReader br = new BufferedReader(fr); //buffered reader allows reading of single line
		FastqReader fqr = new FastqReader(br); //passes in the br to created FastqReader class, reads file all at once

		//Chain of writers.
		FileWriter fw = new FileWriter(fasta); //allows us to write to a fasta file
		PrintWriter pw = new PrintWriter(fw); //allows us to print individually to the file and on separate lines
		FastaWriter faw = new FastaWriter(pw); //passes the printing to the created FastaWriter class, which can write the lines needed
		FastqRecord qTemp = null; //creates a temporary FastqRecord
		boolean finished = false;
		while(!finished) {
			try {	
				/**
				 * Try the following
				 * Create a temporary fastqrecord
				 * check the filereader to see if there is a non-null record
				 * check if it is low quality
				 * if it isn't low quality, create a temporary fastarecord, passing in the FastqRecord
				 * use the record writer faw to write the record to the file
				 */
				//System.out.println("Begin loop");
				qTemp = fqr.readRecord();
			    if (qTemp != null) { 
			    	//there is still stuff to do
			    	 if(!qTemp.qualityIsLow()) {
			    		 //quality is good, continue
			    		 faw.writeRecord(new FastaRecord(qTemp));
			    	 }
			     }
			    else {
			    	//there isn't stuff to do
			    	finished = true;
			    }	
		}
			
		catch (RecordFormatException x) {
			System.out.println("Please fix the formatting issue within the file:\n" + x.getMessage());
		}
	}

		pw.close(); fw.close(); br.close(); fr.close(); // Closes fr, br, fw, and pw in reverse order of creation.
		
	}
			
			
			 
public static void main(String[] args) {
	System.out.println("Starting");
	try {
		File fastq = new File("data/HW4.fastq");
		if (!fastq.exists()) {
			System.out.println("Can't find input file " + fastq.getAbsolutePath());
			System.exit(1);
		}
		File fasta = new File("data/HW4.fasta");
		FileConverter converter = new FileConverter(fastq, fasta);
		converter.convert();
	} catch (IOException x) {
		System.out.println(x.getMessage());
	}
	System.out.println("Done");
}
}