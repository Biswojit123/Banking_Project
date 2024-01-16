

import com23.biswo.service.AccountService;
import com23.biswo.service.AcountServiceImp;

public class AccountSeviceFactory {

    private static AccountService accountSer = null;

    static {
        accountSer = new AcountServiceImp();
    }

    public static AccountService getAccountService() {
        return accountSer ;
    }
}
