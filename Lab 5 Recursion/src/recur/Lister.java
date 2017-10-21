package recur;

import java.io.File;

public class Lister {
	File file;
	boolean showHidden;
	
	public Lister(File file, boolean showHidden) {
		this.file=file;
		this.showHidden=showHidden;
	}
	
	public void list() {
		listRecurse(file,"");
	}
	
	private void listRecurse(File current, String indent) {
		String name = current.getName();

		
		if(current.isFile()) {
			if(showHidden) {
				
				System.out.println(indent +name);
			}
			else if(name.charAt(0)!='.') {
				System.out.println(indent +name);
			}
		}
		
		else if(showHidden||(!showHidden && name.charAt(0)!='.')) {
			
				System.out.println(indent+name+":");
			
		
			String [] filelist = current.list();
			for(String next: filelist) {
				File h = new File(current,next);
				listRecurse(h,indent+" ");
			}
			
		}
		
	}
	
	public static void main (String[] args) { 
		File workingFile = new File("C:\\Users\\Ian\\Documents\\lab5workspace");
		Lister workingLister = new Lister(workingFile,false);
		workingLister.list();
		
		
		
		
	}

}
