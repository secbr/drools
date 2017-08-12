package com.secbro.drools.chapter2;

import com.secbro.drools.model.Goods;
import org.junit.Test;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.util.Collection;

/**
 * Created by zhuzs on 2017/8/12.
 */
public class Drools5ApiTest {

    @Test
    public void testDrools5Api(){

        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("com/rules/goods.drl",this.getClass()),
                ResourceType.DRL);

        if(kbuilder.hasErrors()){
            System.out.println(kbuilder.getErrors());
        }

        KnowledgeBase knowledgeBase = kbuilder.newKnowledgeBase();
        Collection<KnowledgePackage> pks = kbuilder.getKnowledgePackages();
        knowledgeBase.addKnowledgePackages(pks);

        StatefulKnowledgeSession statefulKnowledgeSession = knowledgeBase.newStatefulKnowledgeSession();

        Goods goods = new Goods();

        statefulKnowledgeSession.insert(goods);

        int count = statefulKnowledgeSession.fireAllRules();
        statefulKnowledgeSession.dispose();

        System.out.println("Fire " + count + " rule(s)!");
        System.out.println("The new discount is " + goods.getDiscount() + "%");
    }
}
