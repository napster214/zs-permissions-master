package cn.com.zs.permissions.validator;

import cn.com.zs.permissions.utils.GsonUtils;
import cn.com.zs.permissions.utils.ValidatorUtils;
import cn.com.zs.permissions.utils.validator.SimpleMessageInterpolator;
import cn.com.zs.permissions.utils.validator.ValidatorResult;
import cn.com.zs.permissions.web.user.entity.SysUser;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 标题:
 * <p>
 * 描述:
 * <p>
 * 版权: Copyright (c) 2018
 * <p>
 *
 * @author 张顺
 * @version 1.0
 * @created 2018/2/15-11:29
 */
public class ValidatorTest {

    public static void main(String[] args) {
//        SysUser sysUser = new SysUser();
//        List<SysUser> list = new ArrayList<>();
//        list.add(sysUser);
//        list.add(new SysUser());
//        ValidatorUtils.validateList(list);
    }

    private static Validator validator;

    private static ValidatorFactory validatorFactory;

    static {
        validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .messageInterpolator(new SimpleMessageInterpolator())
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public static void validateList(List<Object> objectList,Class<?>... groups){
        List<ValidatorResult> resultList = new ArrayList<>();
        objectList.forEach(object -> {
            validateHandler(resultList,object,groups);
        });
    }

    private static void validateHandler(List<ValidatorResult> resultList,
                                        Object object,Class<?>... groups){

        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(object,groups);
        if (!constraintViolationSet.isEmpty()){
            constraintViolationSet.forEach(constraintViolation -> {
                ValidatorResult validatorResult = new ValidatorResult();
                validatorResult.setMessage(constraintViolation.getMessage());
                constraintViolation.getPropertyPath().forEach(s -> {
                    validatorResult.setProperty(s.getName());
                });
                resultList.add(validatorResult);
            });
        }
        if (!resultList.isEmpty()){
            throw new RuntimeException(GsonUtils.toJson(resultList));
        }
    }
}
