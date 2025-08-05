package springprograms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("BankObj_1234")
public class Bank_AutoWireAnno {

	@Value("HDFC")
	String bankname;

	@Value("Thananya")
	String mgrname;
	/*
	 * The @Qualifier annotation is used in conjunction with @Autowired to avoid confusion when we have 
	 * two or more beans configured for the same type.
	 */
	/*
	 * The @Qualifier annotation is used to resolve the autowiring conflict, 
	 * when there are multiple beans of same type.
	 */
	/*
	 * IF NO @Qualifer::
	 * 
	 * Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
	 * No qualifying bean of type 'com.programs.Branch' available: expected single matching bean but 
	 * found 2: mybranch,bobj

	 */
	@Qualifier(value="bobj")//Bangalore Karnataka
	//@Qualifier(value="mybranch")//Chennai Tamilnadu
	@Autowired	
	Branch b20;

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getMgrname() {
		return mgrname;
	}

	public void setMgrname(String mgrname) {
		this.mgrname = mgrname;
	}

	public Branch getB20() {
		return b20;
	}

	public void setB20(Branch b20) {
		this.b20 = b20;
	}



}
