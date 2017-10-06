package dna;

import java.io.*;




public class FastaWriter 
{
	PrintWriter thePrintWriter;
	//takes the incoming PrintWriter and allows us to write back to the file
	public FastaWriter(PrintWriter pw) {
		thePrintWriter=pw;
	}

	//prints whatever you had in the temp fastarecord to the fasta file
	//using println methods of PrintWriter, we can write to separate lines
	public void writeRecord(FastaRecord rec) throws IOException
	{
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());

	}
}
