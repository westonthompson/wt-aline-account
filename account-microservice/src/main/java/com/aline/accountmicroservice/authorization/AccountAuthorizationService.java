package com.aline.accountmicroservice.authorization;

import com.aline.core.model.Member;
import com.aline.core.model.account.Account;
import com.aline.core.model.user.MemberUser;
import com.aline.core.model.user.UserRole;
import com.aline.core.security.service.AbstractAuthorizationService;
import org.springframework.stereotype.Component;

@Component("accountAuth")
public class AccountAuthorizationService extends AbstractAuthorizationService<Account> {

    @Override
    public boolean canAccess(Account returnObject) {

        if (getRole() == UserRole.MEMBER) {
            MemberUser user = (MemberUser) getUser();
            Member member = user.getMember();
            return member.getAccounts().contains(returnObject);
        }

        return roleIsManagement();
    }

    /**
     * @param membershipId of the accounts trying to be accessed
     * @return A boolean whether the resource can be accessed
     */
    public boolean canAccess(String membershipId) {

        if (getRole() == UserRole.MEMBER) {

            MemberUser user = (MemberUser) getUser();

            Member member = user.getMember();

            return membershipId.equals(member.getMembershipId());

        }

        return roleIsManagement();
    }
}
