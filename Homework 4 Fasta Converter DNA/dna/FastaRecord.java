package dna;


public class FastaRecord implements DNARecord 
{	
	String defline;
	String sequence;
	/**
	 * precondition check
	 * @param defline
	 * @param sequence
	 * @throws RecordFormatException
	 * Checks and throws an error if first char is not @
	 */
	public FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		this.defline=defline;
		this.sequence=sequence;
		if(this.defline.charAt(0)!='>') {
			throw new RecordFormatException("Bad 1st character in defline of fasta record: saw "+this.defline.charAt(0)+", expected >");
		}
		
		
	}
	
	//ctor chain
	//converts a Fastq to a Fasta using existing vars
	public FastaRecord(FastqRecord fastqRec)
	{
		
		sequence=fastqRec.getSequence();
		defline=(">"+fastqRec.getDefline().substring(1));

	}
	
	

	@Override
	public String getDefline() {
		return this.defline;
	}


	@Override
	public String getSequence() {
		return this.sequence;
	}
	
	
	//Returns whether the second FastqRecord is deep equals to this current instance
	
		public boolean equals(FastaRecord that) {
			if(this.defline.equals(that.defline) && this.sequence.equals(that.sequence)) {
				return true;
			}
			else
				return false;
		}

		//override's Object's hashCode method and returns the sum of the String vars hashcodes
		//the string vars are defline and sequence
		@Override
		public int hashCode() {
			return (this.defline.hashCode()+this.sequence.hashCode());
		}

		



}
