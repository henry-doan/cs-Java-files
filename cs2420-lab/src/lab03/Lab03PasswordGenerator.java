package lab03;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import lab03.constructs.CoursePersonel;
import lab03.constructs.Student;

/**
 * Lab03PasswordGenerator implements a PasswordGenerator, and is itself Generic. 
 * 
 */
public class Lab03PasswordGenerator<T extends Passwordable> implements PasswordGenerator<T>{

	/**
	 * Call createMd5Hash, and pass in the "passwordableFiled" from the supplied key.
	 * Print out the full hash, then return the first eight characters.
	 * @param key
	 * @return
	 */
	// missing method from interface
	
	@SuppressWarnings("unused")
	private String createMd5Hash(String input) {
		MessageDigest md5 = getmd5();
		md5.update(input.getBytes());
		byte byteData[] = md5.digest();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < byteData.length; i++) {
			//convert byte to pretty ascii string, ensuring a leading zero.
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
	
	private MessageDigest getmd5() {
		try {
			 return MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// MD5 should always work.
		}
		return null;
	}
	
	public static void main(String[] args) {
		// make a Lab03PasswordGenerator that can take any passwordable. What can be passed into the generatePassword method? 
		// make a Lab03PasswordGenerator that can take any CoursePersonel. What can be passed into the generatePassword method? 
		// make a Lab03PasswordGenerator that can take any TeacherAssistant. What can (and cannot) be passed into the generatePassword method? 

		Lab03PasswordGenerator<Student> students = new Lab03PasswordGenerator();
		String yourpassword = students.generatePassword(new Student("name", "u0674937"));
		System.out.println("password: " + yourpassword);
		// make a Lab03PasswordGenerator that is parameterized with Students
		// Run the password function, and supply it to cs2420-lab.eng.utah.edu
	}

	@Override
	public String getPasswordableKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generatePassword(T key) {
		String seed = key.getPasswordableKey();
		String fullHash = createMd5Hash(seed);
		return fullHash.substring(0, 8);
	}

	
}
