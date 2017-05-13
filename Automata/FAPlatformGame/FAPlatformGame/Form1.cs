using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FAPlatformGame
{
    public partial class Form1 : Form
    {
        int c_state = 0;
        public Form1()
        {
            InitializeComponent();
            hideAllWoodys();
            woody1.Visible = true;
            Random rnd = new Random();
            Console.WriteLine(rnd.Next(1, 10));
        }

        public void hideAllWoodys()
        {
            woody1.Visible = false;
            woody2.Visible = false;
            woody3.Visible = false;
            woody4.Visible = false;
            woody5.Visible = false;
            woody6.Visible = false;
            woody7.Visible = false;
            woody8.Visible = false;
            woody9.Visible = false;
            woody10.Visible = false;
        }

        private void pictureBox6_Click(object sender, EventArgs e)
        {

        }

        private void plat1_Click(object sender, EventArgs e)
        {
            int state = 0;
            if (dfa.transition(c_state, state))
            {
                hideAllWoodys();
                woody1.Visible = true;
                c_state = 0;
            }
            else
            {
                MessageBox.Show("Invalid Move");
            }
        }

        private void plat2_Click(object sender, EventArgs e)
        {
            int state = 1;
            if (dfa.transition(c_state, state))
            {
                hideAllWoodys();
                woody2.Visible = true;
                c_state = 1;
            }
            else
            {
                MessageBox.Show("Invalid Move");
            }
        }

        private void plat3_Click(object sender, EventArgs e)
        {
            int state = 2;
            if (dfa.transition(c_state, state))
            {
                hideAllWoodys();
                woody3.Visible = true;
                c_state = 2;
            }
            else
            {
                MessageBox.Show("Invalid Move");
            }
        }

        private void plat4_Click(object sender, EventArgs e)
        {
            int state = 3;
            if (dfa.transition(c_state, state))
            {
                hideAllWoodys();
                woody4.Visible = true;
                c_state = 3;
            }
            else
            {
                MessageBox.Show("Invalid Move");
            }
        }

        private void plat6_Click_1(object sender, EventArgs e)
        {
            int state = 5;
            if (dfa.transition(c_state, state))
            {
                hideAllWoodys();
                woody6.Visible = true;
                c_state = 5;
            }
            else
            {
                MessageBox.Show("Invalid Move");
            }
        }

        private void plat5_Click_1(object sender, EventArgs e)
        {
            int state = 4;
            if (dfa.transition(c_state, state))
            {
                hideAllWoodys();
                woody5.Visible = true;
                c_state = 4;
            }
            else
            {
                MessageBox.Show("Invalid Move");
            }
        }

        private void plat7_Click(object sender, EventArgs e)
        {
            int state = 6;
            if (dfa.transition(c_state, state))
            {
                hideAllWoodys();
                woody7.Visible = true;
                c_state = 6;
            }
            else
            {
                MessageBox.Show("Invalid Move");
            }
        }

        private void plat8_Click(object sender, EventArgs e)
        {
            int state = 7;
            if (dfa.transition(c_state, state))
            {
                hideAllWoodys();
                woody8.Visible = true;
                c_state = 7;
            }
            else
            {
                MessageBox.Show("Invalid Move");
            }
        }

        private void plat9_Click(object sender, EventArgs e)
        {
            int state = 8;
            if (dfa.transition(c_state, state))
            {
                hideAllWoodys();
                woody9.Visible = true;
                c_state = 8;
            }
            else
            {
                MessageBox.Show("Invalid Move");
            }
        }

        private void plat10_Click(object sender, EventArgs e)
        {
            int state = 9;
            if (dfa.transition(c_state, state))
            {
                hideAllWoodys();
                woody10.Visible = true;
                c_state = 9;
                MessageBox.Show("Congratulations Woddy is now home !");
                Application.Restart();
            }
            else
            {
                MessageBox.Show("Invalid Move");
            }
        }
    }

    public class dfa
    {

        static int[,] TransitionTable = new int[,] 
        {{ 1,1,1,0,0,0,0,0,0,0},
        { 1,1,0,1,1,0,0,0,0,0},
        { 1,0,1,1,0,0,0,0,0,0},
        { 1,1,1,1,0,1,1,0,0,0},
        { 1,1,0,0,1,1,0,0,0,0},
        { 0,1,0,1,1,1,0,1,0,0},
        { 0,0,0,1,0,0,1,0,1,0},
        { 0,0,0,0,1,1,0,1,0,1},
        { 0,0,0,0,0,1,1,0,1,1},
        { 0,0,0,0,0,0,0,0,0,1}};


        public static Boolean transition(int curr_state, int next_state)
        {
            if (TransitionTable[curr_state, next_state] == 1)
            {
                return true;
            }
            return false;
        }

    }
}
