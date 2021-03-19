package com.mphasis.gc;

import javax.management.*;
import java.lang.management.ManagementFactory;

/*
 *  Testing GCTestAgent through main method
 */
public class GCTestMain {

    private static void init() {
        MBeanServer mbs = null;
        mbs= ManagementFactory.getPlatformMBeanServer();
        GCTestAgent agent = new GCTestAgent();
        ObjectName agentName;

        try {
            agentName= new ObjectName("AATests:name= GCTestAgent");
            mbs.registerMBean(agent, agentName);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        init();
        System.out.println("Running");
        for (;;) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
