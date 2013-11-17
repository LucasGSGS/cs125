//UIUC CS125 FALL 2013 MP. File: InsecurePasswordLockBreaker.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2013-11-12T09:02:55-0600.414969527
public class InsecurePasswordLockBreaker {

	public static char[] breakLock(InsecurePasswordLock lock) {
		int length = 0;
		for (int i = 30; i < 51; i++) {
			char[] key = new char[i];
			if (lock.open(key) != -1) { length = i; break; }	//found the correct length
		}
		char[] retval = new char[length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; lock.open(retval) != i + 1; j++) {	//letter after current letter is wrong
				retval[i] = (char)j;							//which implies current letter is right
			}
		}
		return retval;
	}

	public static void main(String[] args) {
		InsecurePasswordLock lock = new InsecurePasswordLock(35);
		char[] key = breakLock(lock);
		System.out.println(key);
		System.out.println(lock.isUnlocked());
	}
}
