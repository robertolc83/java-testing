package com.robertolc.util;

import org.junit.Assert;
import org.junit.Test;

import static com.robertolc.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.assertEquals;

public class PasswordUtilTest {
    @Test
    public void weak_when_has_less_than_8_letters(){
        Assert.assertEquals(WEAK,PasswordUtil.assessPassword("1234A!"));
    }
    @Test
    public void weak_when_has_only_letters(){
        Assert.assertEquals(WEAK,PasswordUtil.assessPassword("qwertyui"));
    }
    @Test
    public void medium_when_has_letters_and_numbers(){
        Assert.assertEquals(MEDIUM,PasswordUtil.assessPassword("qwer1234"));
    }
    @Test
    public void strong_when_has_letters_numbers_and_symbols(){
        Assert.assertEquals(STRONG,PasswordUtil.assessPassword("asd123$$"));
    }
}