package Service.Impl;


import Service.AriService;
import Utils.AriUtils;
import empty.Ari;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AriServiceImpl implements AriService {


    //获取整式
    @Override
    public List<Ari> getint(){
        List<Ari> aris = new ArrayList<>();
        int n=20;
        AriUtils fourAri = new AriUtils();
        while (aris.size() < n) {
            Map<String, Integer> map = fourAri.FourAri();
            // 1. entrySet遍历，在键和值都需要时使用（最常用）
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                Ari ari = new Ari(entry.getKey(), entry.getValue().toString());
                aris.add(ari);
            }
        }
        return aris;
    }

    @Override
    public  List<Ari> getbracket(){
        List<Ari> aris = new ArrayList<>();
        int n=20;
        AriUtils backetAri = new AriUtils();
        while (aris.size()<n) {
            Map<String, Integer> map = backetAri.BacketAri();
            // 1. entrySet遍历，在键和值都需要时使用（最常用）
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                Ari ari = new Ari(entry.getKey(), entry.getValue().toString());
                aris.add(ari);
            }
        }
        return aris;
    }
}
