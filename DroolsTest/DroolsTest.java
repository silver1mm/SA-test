package com.sample;

import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            Scanner in = new Scanner(System.in);
            System.out.println("��������Ҫ�����ķ�����������0�˳�ѭ����");
            int data = in.nextInt();
            while(data!=0) {
                Score s = new Score(data);
                kSession.insert(s);
                kSession.fireAllRules();
                System.out.println("��������Ҫ�����ķ�����������0�˳�ѭ����");
                data = in.nextInt();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    public static class Score{
        public int score;
        Score(int Score){
            score = Score;
        }
        public int getScore() {
            return score;
        }
    }

}