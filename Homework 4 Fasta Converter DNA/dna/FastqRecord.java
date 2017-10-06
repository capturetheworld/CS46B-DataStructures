package dna;


public class FastqRecord implements DNARecord 
{
	String defline;
	String sequence;
	String quality;

//Accepts fastqrecord checks that it starts with @, otherwise throws an error
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException
	{
		this.defline=defline;
		this.sequence=sequence;
		this.quality=quality;
		
		if(this.defline.charAt(0)!='@') {
			throw new RecordFormatException("The 1st character in defline should be @, not "+this.defline.charAt(0)+".");
		}
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
	
	public boolean equals(FastqRecord that) {
		if(this.defline.equals(that.defline) && this.sequence.equals(that.sequence) && this.quality.equals(that.quality)) {
			return true;
		}
		else
			return false;
	}
	
	//override's Object's hashCode method and returns the sum of the String vars hashcodes
	//the string vars are defline, sequence, and quality
	@Override
	public int hashCode() {
		return (this.defline.hashCode()+this.sequence.hashCode()+this.quality.hashCode());
	}
	
	//returns true if there is a quality problem, else it's false
	public boolean qualityIsLow()
	{
	
		if(this.quality.contains("!")) {
			return true;
		}
		return false;

	}
	

	
}
