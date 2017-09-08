package com.savsh.service;

import com.savsh.entity.Chin;
import com.savsh.repository.ChinRepository;
import com.sun.org.apache.xerces.internal.xinclude.XIncludeTextReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChinService {

    @Autowired
    private ChinRepository chinRepository;

    public Iterable<Chin> findAll() {
        return chinRepository.findAll();
    }

    public Chin getChinById(long id) {
        return chinRepository.findOne(id);
    }

    public void deleteChinById(long id) {
        chinRepository.delete(id);
    }

    public Chin updateChin(Chin chin) {
        return chinRepository.save(chin);
    }

    public Chin insertChin(Chin chin) {
        return chinRepository.save(chin);
    }

//    for ancestors buttons

    public Iterable<Chin> getParrentsOfChinById(long id) {
        List<Chin> list = new ArrayList<>();
        Chin chin = getChinById(id);
        long fatherId = chin.getFatherId();
        long motherId = chin.getMotherId();

        if (fatherId != 0) {
            list.add(getChinById(fatherId));
        }

        if (motherId != 0) {
            list.add(getChinById(motherId));
        }

        list.removeIf(chin1 -> chin1 == null);
        return list;
    }

    public Iterable<Chin> getGrandParrentsOfChinById(long id) {
        Iterable<Chin> parrents = getParrentsOfChinById(id);
        List<Chin> list = new ArrayList<>();
        parrents.forEach(
                chin -> {if (chin != null) {saveParrentsOfParrentsInNGeneration(chin.getId(), list);}}
        );
        list.removeIf(chin -> chin == null);
        return list;
    }

    public Iterable<Chin> getGreatGrandParrentsOfChinById(long id) {
        Iterable<Chin> grandParrents = getGrandParrentsOfChinById(id);
        List<Chin> list = new ArrayList<>();
        grandParrents.forEach(chin -> {
            if (chin != null) {saveParrentsOfParrentsInNGeneration(chin.getId(), list);}
        });
        list.removeIf(chin -> chin == null);
        return list;
    }

    public Iterable<Chin> getGreatGreatGrandParrentsOfChinById(long id) {
        Iterable<Chin> greatGrandParrents = getGreatGrandParrentsOfChinById(id);
        List<Chin> list = new ArrayList<>();
        greatGrandParrents.forEach(
                chin -> {
                    if (chin != null) {saveParrentsOfParrentsInNGeneration(chin.getId(), list);}
                });
        list.removeIf(chin -> chin == null);
        return list;
    }

    public Iterable<Chin> getAllAncestorsUpTo10Generations(long id) {
        List<Chin> list = new ArrayList<>();
        list.addAll(getGreatGreatGreatGrandParrentsOfChinById(id));
        list.addAll(getGreatGreatGreatGreatGrandParrentsOfChinById(id));
        list.addAll(getGreatGreatGreatGreatGreatGrandParrentsOfChinById(id));
        list.addAll(getGreatGreatGreatGreatGreatGreatGrandParrentsOfChinById(id));
        list.removeIf(chin -> chin == null);
        return list;
    }

    private List<Chin> getGreatGreatGreatGrandParrentsOfChinById(long id) {
        Iterable<Chin> greatGreatGrandParrents = getGreatGreatGrandParrentsOfChinById(id);
        List<Chin> list = new ArrayList<>();
        for (Chin chin : greatGreatGrandParrents) {
            saveParrentsOfParrentsInNGeneration(chin.getId(), list);
        }

        return list;
    }

    private List<Chin> getGreatGreatGreatGreatGrandParrentsOfChinById(long id) {
        Iterable<Chin> greatGreatGreatGrandParrents = getGreatGreatGreatGrandParrentsOfChinById(id);
        List<Chin> list = new ArrayList<>();
        greatGreatGreatGrandParrents.forEach(
                chin -> {
                    if (chin != null) {saveParrentsOfParrentsInNGeneration(chin.getId(), list);}
                });
        return list;
    }

    private List<Chin> getGreatGreatGreatGreatGreatGrandParrentsOfChinById(long id) {
        Iterable<Chin> greatGreatGraetGreatGreatGrandParrents = getGreatGreatGreatGreatGrandParrentsOfChinById(id);
        List<Chin> list = new ArrayList<>();
        greatGreatGraetGreatGreatGrandParrents.forEach(
                chin -> {
                    if (chin != null) {saveParrentsOfParrentsInNGeneration(chin.getId(), list);}
                });

        return list;
    }

    private List<Chin> getGreatGreatGreatGreatGreatGreatGrandParrentsOfChinById(long id) {
        Iterable<Chin> greatGreatGreatGraetGreatGreatGrandParrents = getGreatGreatGreatGreatGreatGrandParrentsOfChinById(id);
        List<Chin> list = new ArrayList<>();
        greatGreatGreatGraetGreatGreatGrandParrents.forEach(
                chin -> {
                    if (chin != null) {saveParrentsOfParrentsInNGeneration(chin.getId(), list);}
                });

        return list;
    }

    private void saveParrentsOfParrentsInNGeneration(long id, List<Chin> list) {
        Iterable<Chin> parrents = getParrentsOfChinById(id);
        parrents.forEach(chin -> {if (chin != null) {list.add(chin);}});
    }

//    Others

    public List<Chin> getBrothersAndSistersOfChinById(long id) {
        Iterable<Chin> allChins = findAll();
        List<Chin> list = new ArrayList<>();
        for (Chin chin : allChins) {
            list.add(chin);
        }

        long fatherId = getChinById(id).getFatherId();
        long motherId = getChinById(id).getMotherId();

        list.removeIf(chin -> !(chin.getFatherId() == fatherId && chin.getMotherId() == motherId));
        list.removeIf(chin -> chin.getId() == id);
        return list;
    }

    public Iterable<Chin> getHalfBrothersAndHalfSistersOfChinById(long id) {
        Iterable<Chin> allChins = findAll();
        List<Chin> list = new ArrayList<>();
        for (Chin chin : allChins) {
            list.add(chin);
        }

        long fatherId = getChinById(id).getFatherId();
        long motherId = getChinById(id).getMotherId();

        list.removeIf(chin -> !(chin.getFatherId() == fatherId ^ chin.getMotherId() == motherId));

        return list;
    }

    public List<Chin> getUnclesAndAunts(long id) {
        Iterable<Chin> parrens = getParrentsOfChinById(id);
        List<Chin> unclesAndAunts = new ArrayList<>();
        for (Chin chin : parrens) {
            unclesAndAunts.addAll(getBrothersAndSistersOfChinById(chin.getId()));
        }
        return unclesAndAunts;
    }

    public List<Chin> getCousinsOfChinById(long id) {
        Iterable<Chin> unclesAndAunts = getUnclesAndAunts(id);
        Iterable<Chin> allChin = findAll();
        List<Chin> cousins = new ArrayList<>();
        for (Chin chin : allChin) {
            for (Chin uncleOrAunt: unclesAndAunts) {
                if (chin.getFatherId() == uncleOrAunt.getId() || chin.getMotherId() == uncleOrAunt.getId()) {
                    cousins.add(chin);
                }
            }
        }
        return cousins;
    }

    public List<Chin> getChildrenOfChinById(long id) {
        Iterable<Chin> allChins = findAll();
        List<Chin> children = new ArrayList<>();
        for (Chin chin : allChins) {
            Iterable<Chin> parrens = getParrentsOfChinById(chin.getId());
            for (Chin parrent : parrens) {
                if (parrent.getId() == id) {
                    children.add(chin);
                }
            }

        }
        return children;
    }

    public List<Chin> getGrandChildrenOfChinById(long id) {
        Iterable<Chin> allChins = findAll();
        List<Chin> grandChildren = new ArrayList<>();
        for (Chin chin : allChins) {
            Iterable<Chin> grandParrents = getGrandParrentsOfChinById(chin.getId());
            for (Chin grandParren : grandParrents) {
                if (grandParren.getId() == id) {
                    grandChildren.add(chin);
                }
            }
        }
        return grandChildren;
    }

   public List<Chin> getAllChildrenOfChinById(long id) {
        Iterable<Chin> allChins = findAll();
        List<Chin> allChildrenOfAllGenertion = new ArrayList<>();
        for (Chin chin : allChins) {
            Iterable<Chin> greatGrandParrents = getGreatGrandParrentsOfChinById(chin.getId());
            for (Chin greatGrandParrent : greatGrandParrents) {
                if (greatGrandParrent.getId() == id) {
                    allChildrenOfAllGenertion.add(chin);
                }
            }

            Iterable<Chin> greatGreatGrandParrents = getGreatGreatGrandParrentsOfChinById(chin.getId());
            for (Chin greatGreatGrandParrent : greatGreatGrandParrents) {
                if (greatGreatGrandParrent.getId() == id) {
                    allChildrenOfAllGenertion.add(chin);
                }
            }

            Iterable<Chin> allGenerationUpTo10Children = getAllAncestorsUpTo10Generations(chin.getId());
            for (Chin allGenerationChin : allGenerationUpTo10Children) {
                if (allGenerationChin.getId() == id) {
                    allChildrenOfAllGenertion.add(chin);
                }
            }
        }

        return allChildrenOfAllGenertion;
   }

}
