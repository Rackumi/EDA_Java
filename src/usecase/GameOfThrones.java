package usecase;

import material.Position;
import material.tree.iterators.BFSIterator;
import material.tree.iterators.PreorderIterator;
import material.tree.narytree.LinkedTree;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public class GameOfThrones<t1> {

    private static class Pj{

        private String name;
        private String surname;
        private String gender;
        private int age;


        public Pj(String name, String surname ,String gender, int age) {
            this.name = name;
            this.surname = surname;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }

    private static LinkedTree<Pj> tAA;
    private static LinkedTree<Pj> tAL;
    private static LinkedTree<Pj> tAR;
    private static LinkedTree<Pj> tBD;
    private static LinkedTree<Pj> tBI;
    private static LinkedTree<Pj> tBR;

    private static LinkedList<Pj> lista;

    public static void loadFile(){

        Pj AA = new Pj("Rickard", "Stark", "M", 67);
        Pj AB = new Pj("Eddard", "Stark", "M", 40);
        Pj AC = new Pj("Catalyn", "Tully", "F", 35);
        Pj AD = new Pj("Brandon", "Stark", "M", 15);
        Pj AE = new Pj("Benjen", "Stark", "M", 35);
        Pj AF = new Pj("Jon", "Snow", "M", 17);
        Pj AG = new Pj("Robb", "Stark", "M", 17);
        Pj AH = new Pj("Sansa", "Stark", "F", 16);
        Pj AI = new Pj("Arya", "Stark", "F", 14);
        Pj AJ = new Pj("Bran", "Stark", "M", 13);
        Pj AK = new Pj("Rickon ", "Stark", "N", 11);

        Pj AL = new Pj("Hoster", "Tully", "M", 72);
        Pj AN = new Pj("Edmure", "Tully", "M", 42);
        Pj AO = new Pj("Lysa", "Tully", "F", 40);
        Pj AQ = new Pj("Robert", "Arryn", "M", 24);

        Pj AR = new Pj("Tytos", "Lannister", "M", 80);
        Pj AS = new Pj("Tywin", "Lannister", "M", 64);
        Pj AU = new Pj("Kevan", "Lannister", "M", 62);
        Pj AV = new Pj("Cersei", "Lannister", "F", 36);
        Pj AW = new Pj("Jamie", "Lannister", "M", 35);
        Pj AX = new Pj("Tyrion", "Lannister", "M", 30);
        Pj AY = new Pj("Robert", "Baratheon", "M", 3);
        Pj AZ = new Pj("Joffrey", "Baratheon", "M", 18);
        Pj BA = new Pj("Myrcella", "Baratheon", "F", 23);
        Pj BB = new Pj("Tommen", "Baratheon", "M", 16);
        Pj BC = new Pj("Lancel", "Lannister", "M", 34);

        Pj BD = new Pj("Steffon", "Baratheon", "M", 65);
        Pj BE = new Pj("Stannis", "Baratheon", "M", 45);
        Pj BG = new Pj("Shireen", "Baratheon", "F", 20);
        Pj BH = new Pj("Renly", "Baratheon", "M", 38);

        Pj BI = new Pj("Jaehaerys", "Targaryen", "M", 74);
        Pj BJ = new Pj("Aerys", "Targaryen", "M", 53);
        Pj BK = new Pj("Rhaella", "Targaryen", "F", 52);
        Pj BL = new Pj("Rhaegar", "Targaryen", "M", 32);
        Pj BN = new Pj("Rhaenys", "Targaryen", "F", 17);
        Pj BO = new Pj("Aegon", "Targaryen", "M", 14);
        Pj BP = new Pj("Viserys", "Targaryen", "M", 36);
        Pj BQ = new Pj("Daenerys", "Targaryen", "F", 27);

        Pj BR = new Pj("Quellon ", "Greyjoy", "M", 85);
        Pj BS = new Pj("Balon", "Greyjoy", "M", 47);
        Pj BT = new Pj("Euron", "Greyjoy", "M",46 );
        Pj BU = new Pj("Victarion", "Greyjoy", "M", 41);
        Pj BV = new Pj("Urrigon", "Greyjoy", "M", 40);
        Pj BW = new Pj("Aeron", "Greyjoy", "M", 48);
        Pj BX = new Pj("Rodrik", "Greyjoy", "M", 20);
        Pj BY = new Pj("Maron", "Greyjoy", "M", 22);
        Pj BZ = new Pj("Asha", "Greyjoy", "F", 18);
        Pj CA = new Pj("Theon", "Greyjoy", "M", 23);

//        lista = new LinkedList<>();
//        lista.add(AA);
//        lista.add(AB);
//        lista.add(AE);
//        lista.add(AF);
//        lista.add(AG);
//        lista.add(AH);
//        lista.add(AI);
//        lista.add(AJ);
//        lista.add(AK);
//        lista.add(AL);
//        lista.add(AC);
//        lista.add(AN);
//        lista.add(AO);
//        lista.add(AQ);
//        lista.add(AR);
//        lista.add(AU);
//        lista.add(AS);
//        lista.add(AV);
//        lista.add(AW);
//        lista.add(AW);
//        lista.add(AX);
//        lista.add(BC);
//        lista.add(AY);
//        lista.add(BE);
//        lista.add(BH);
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();
//        lista.add();


        //XXXXXXXXXXXXXXXXXXXXXXXXXX Stark tree XXXXXXXXXXXXXXXXXXXXXXXXXX 10

        tAA = new LinkedTree<>();

        Position<Pj> raizAA = tAA.addRoot(AA);

        tAA.add(AD, raizAA);
        Position<Pj> nodeAB = tAA.add(AB, raizAA);
        tAA.add(AE, raizAA);

        tAA.add(AF, nodeAB);
        tAA.add(AG, nodeAB);
        tAA.add(AH, nodeAB);
        tAA.add(AI, nodeAB);
        tAA.add(AJ, nodeAB);
        tAA.add(AK, nodeAB);

        //XXXXXXXXXXXXXXXXXXXXXXXXXX Tully tree XXXXXXXXXXXXXXXXXXXXXXXXXX 5

        tAL = new LinkedTree<>();

        Position<Pj> raizAL = tAL.addRoot(AL);

        tAL.add(AC, raizAL);
        tAL.add(AN, raizAL);
        Position<Pj> nodeAO = tAL.add(AO, raizAL);

        tAL.add(AQ, nodeAO);

        //XXXXXXXXXXXXXXXXXXXXXXXXXX Lannister tree XXXXXXXXXXXXXXXXXXXXXXXXXX 7

        tAR = new LinkedTree<>();

        Position<Pj> raizAR = tAR.addRoot(AR);

        Position<Pj> nodeAS = tAR.add(AS, raizAR);
        Position<Pj> nodeAU = tAR.add(AU, raizAR);

        tAR.add(AV, nodeAS);
        tAR.add(AW, nodeAS);
        tAR.add(AX, nodeAS);
        tAR.add(BC, nodeAU);

        //XXXXXXXXXXXXXXXXXXXXXXXXXX Baratheon tree XXXXXXXXXXXXXXXXXXXXXXXXXX 8

        tBD = new LinkedTree<>();

        Position<Pj> raizBD = tBD.addRoot(BD);

        Position<Pj> nodeAY = tBD.add(AY, raizBD);
        Position<Pj> nodeBE = tBD.add(BE, raizBD);
        tBD.add(BH, raizBD);

        tBD.add(AZ, nodeAY);
        tBD.add(BA, nodeAY);
        tBD.add(BB, nodeAY);
        tBD.add(BG, nodeBE);

        //XXXXXXXXXXXXXXXXXXXXXXXXXX Tragaryen tree XXXXXXXXXXXXXXXXXXXXXXXXXX 7

        tBI = new LinkedTree<>();

        Position<Pj> raizBI = tBI.addRoot(BI);

        Position<Pj> nodeBJ = tBI.add(BJ, raizBI);

        Position<Pj> nodeBL = tBI.add(BL, nodeBJ);
        tBI.add(BQ, nodeBJ);
        tBI.add(BP, nodeBJ);

        tBI.add(BN, nodeBL);
        tBI.add(BO, nodeBL);

        //XXXXXXXXXXXXXXXXXXXXXXXXXX Greyjoy tree XXXXXXXXXXXXXXXXXXXXXXXXXX 9

        tBR = new LinkedTree<>();

        Position<Pj> raizBR = tBR.addRoot(BR);

        Position<Pj> nodeBS =tBR.add(BS, raizBR);
        tBR.add(BT, raizBR);
        tBR.add(BU, raizBR);
        tBR.add(BW, raizBR);

        tBR.add(BX, nodeBS);
        tBR.add(BY, nodeBS);
        tBR.add(BZ, nodeBS);
        tBR.add(CA, nodeBS);

    }

    public static LinkedTree<Pj> getFamily(String surname){
        switch (surname){
            case "Stark": return tAA;
            case "Tully": return tAL;
            case "Lannister": return tAR;
            case "Baratheon": return tBD;
            case "Targaryen": return tBI;
            case "Greyjoy": return tBR;
            default: throw new RuntimeException("Invalid surname");
        }
    }

    public static String findHeir(String surname){
        LinkedTree<Pj> t = getFamily(surname);
        Iterable<? extends Position<Pj>> hijos = t.children(t.root());
        for(Position<Pj> p: hijos){ //habria que hacerlo con un iterator (inorder creo)
            if(p.getElement().gender == "M"){
                return p.getElement().name;
            }
        }
        return null;
    }

    public void changeFamily(String memberName, String newParent){
        Position<Pj> member = null;
        Position<Pj> parent = null;
        for(Position<Pj> p: tAA){
            if(p.getElement().getName()==memberName){
                member = p;
            }
        }
        for(Position<Pj> p: tAL){
            if(p.getElement().getName()==newParent){
                parent = p;
            }
        }
        tAL.add((Pj) member, parent);
        tAA.remove(member);
    }

    public boolean areFamily(String name1, String name2){
        Pj p1 = null;
        Pj p2 = null;
        return (getFamily(p1.surname) == getFamily(p2.surname));
    }

    public static void main(String[] args){
        loadFile();
        LinkedTree<Pj> t1 = getFamily("Stark");
        LinkedTree<Pj> t2 = getFamily("Tully");
        LinkedTree<Pj> t3 = getFamily("Lannister");
        LinkedTree<Pj> t4 = getFamily("Baratheon");
        LinkedTree<Pj> t5 = getFamily("Targaryen");
        LinkedTree<Pj> t6 = getFamily("Greyjoy");
        System.out.println(t1.size());
        System.out.println(t2.size());
        System.out.println(t3.size());
        System.out.println(t4.size());
        System.out.println(t5.size());
        System.out.println(t6.size());

        System.out.println(findHeir("Stark"));

        System.out.println(lista.size());
    }

}