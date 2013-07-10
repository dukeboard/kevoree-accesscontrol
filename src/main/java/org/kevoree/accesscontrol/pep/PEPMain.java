package org.kevoree.accesscontrol.pep;

import org.kevoree.accesscontrol.*;
import org.kevoree.accesscontrol.factory.MainFactory;
import org.kevoree.accesscontrol.impl.DefaultAccessControlFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: donia.elkateb
 * Date: 7/9/13
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class PEPMain {


    public void main(String[] args) {
        //TODO
        AccessControlFactory factory = new DefaultAccessControlFactory();
        AccessControlPolicy modelAC = factory.createAccessControlPolicy();
        Domain myDomain = factory.createDomain();
        myDomain.setName("IaaSDomain");
        modelAC.addDomains(myDomain);
        Rule rule = factory.createRule();
        rule.setName("rule32");

        //
    }


    public void createrule(String rulename, Subject subject, Condition condition, Resource resources_source, Resource resouces_target, AccessControlPolicy acModel)
    {
    //Action is missing
                 AccessControlFactory factory = new DefaultAccessControlFactory();
                 Rule rule = factory.createRule();
                 rule.setName(rulename);
                 rule.setSubject(subject);
                 rule.setCondition(condition);





                 rule.setSource((List<Resource>) resources_source);
                 rule.setTarget((List<Resource>) resouces_target);
    }

    //Get privileges
    public boolean check(String id, String action, AccessControlPolicy acModel) {
        List<Rule> collectedRules = new ArrayList<Rule>();
        //locate rules from an ID
        Entity entity = acModel.findEntitiesByID(id);

        for (Rule rule : acModel.getRules()) {
            if (rule.getSubject().equals(entity)) {
                collectedRules.add(rule);
            } else {
                for (Role role : entity.getRoles()) {
                    if (rule.getSubject().equals(role)) {
                        collectedRules.add(rule);

                    }
                }
            }
        }
        return true;
    }

    public boolean PDP(String subject, String action, String resources_source, String resouces_target, Domain domain, AccessControlPolicy acModel) {

        //locate rules from an ID
        List<Rule> collectedRules = new ArrayList<Rule>();
        collectedRules = domain.getRules();
        for (Rule rule : collectedRules)
        {
            if ((rule.getSource().equals(resources_source))  && (rule.getSubject().equals(subject)) &&  (rule.getTarget().equals(resouces_target)) )
            {
             return true;
            }
        }
        return false;
    }

    public void delegate(String id,String delegator,String delegatee,AccessControlPolicy acModel)
         //add rules to entity or role
    {
        List<Rule> collectedRules = new ArrayList<Rule>();
        //locate rules from an ID
        Entity entity = acModel.findEntitiesByID(id);
        for (Rule rule : acModel.getRules())
        {
            if (rule.getSubject().equals(delegator))
            {
                collectedRules.add(rule);
            }
       }
        //Entity entity = acModel.findEntitiesByID(id);
       // delegatee.add(collectedRules);
    }


/*
    public Subject conflictresolution(Entity subject, Entity subject1, Domain domain, TimingCondition condition, AccessControlPolicy acModel)
{

      if (subject.getRoles() >= subject1.getRoles())
      {
          return subject;

      else

          return subject1;
      }

      return subject;


}       */


   }