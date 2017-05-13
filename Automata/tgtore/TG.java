/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtore;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TG {
        ArrayList<ArrayList<TransitionObject>> list;
        public TG(ArrayList<ArrayList<TransitionObject>> list)
        {
            this.list = list;
        }
        public String convertToRE()
        {
            for (int i = 0; i < list.size() - 2; i++)
            {
                joinIncomingToOutgoing(i);
            }
            ;
            return list.get(list.size()-2).toString();
        }
        
        public void joinIncomingToOutgoing(int st)
        {

            
            ArrayList<TransitionObject> outgoing = returnAllOutGoing(st);

            
            for(ArrayList<TransitionObject> t : list)
            {

              int index=list.indexOf(t);
                // foreach (Transition item in t)
                if (t != null)
                {
                    concatenate(t);
                    for (int i = 0; i < t.size(); i++)
                    {
                        TransitionObject item = t.get(i);

                        if (item.getState() == st)// it means it is incoming edge
                        {
                            //
                            //
                            //
                            if (index == st) {
//                                selfLoop+=item.getString()+"*";
//                                for every incomg inc
//                                        inc.setstring(inc.getstring()+selfLoop)
                            }
                            for (TransitionObject outgoingItem : outgoing)
                            {
                                t.add(new TransitionObject(item.getString() + outgoingItem.getString(), outgoingItem.getState()));
                            }

                            t.remove(item);
                            i--;

                        }

                    }
                }

            }
            list.remove(st);
            
        }
        ArrayList<TransitionObject> returnAllOutGoing(int st)
        {
            return list.get(st);
        }
        void concatenate(ArrayList<TransitionObject> item)
        {
            for (int i = 0; i < item.size(); i++)
            {
                for (int j = 0; j < item.size(); j++)
                {
                    if (i != j)
                    {
                        if (item.get(i).getState() == item.get(j).getState())
                        {
                            item.get(i).setString("(" + item.get(i).getString() + ")+(" + item.get(j).getString() + ")");
                            item.remove(j);
                            
                        }
                    }
                }
            }
        }
}
