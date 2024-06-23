package com.company.aab.security;

import com.company.aab.entity.Avtomobil;
import com.company.aab.entity.Foto;
import com.company.aab.entity.User;
import com.company.aab.entity.Zayavka;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;

@ResourceRole(name = "User management", code = UserManagementRole.CODE, scope = "API")
public interface UserManagementRole {

    String CODE = "user-management";

    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.CREATE})
    void user();

    @EntityAttributePolicy(entityClass = Zayavka.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Zayavka.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.CREATE})
    void zayavka();

    @EntityAttributePolicy(entityClass = Foto.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Foto.class, actions = EntityPolicyAction.ALL)
    void foto();

    @EntityAttributePolicy(entityClass = Avtomobil.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Avtomobil.class, actions = EntityPolicyAction.ALL)
    void avtomobil();
}