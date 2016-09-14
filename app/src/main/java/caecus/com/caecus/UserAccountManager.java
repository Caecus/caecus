package caecus.com.caecus;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

/**
 * Created by Zotiz on 09/09/2016.
 */

public class UserAccountManager {

        private static String getEmail(Context context) {
            AccountManager accountManager = AccountManager.get(context);
            Account account = getAccount(accountManager);
            String S;
            if (account == null) {
                return null;
            } else {
                return account.name;
            }
        }

        private static Account getAccount(AccountManager accountManager) {
            Account[] accounts = accountManager.getAccountsByType("com.google");
            Account account;
            if (accounts.length > 0) {
                account = accounts[0];
            } else {
                account = null;
            }
            return account;
        }
}
