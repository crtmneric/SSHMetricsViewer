package com.pribas.controller;


import com.jcraft.jsch.Session;
import com.pribas.beans.MetricsReader;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class ConnectionController {
    public static void main(String[] args) {
        String[] str = new String[] {
                "0000     0      0000  0   0  0000      0000   0000   0    0   ",
                "0       0 0    0       0 0  0         0      0       0    0  ",
                "000    00000    0000    0    0000      0000   0000   000000          ",
                "0     0     0       0   0        0         0      0  0    0        ",
                "0000 0       0  0000    0    0000      0000   0000   0    0         "};

        for (int i=0;i<str.length;i++)
        {
            System.out.println(str[i]);
        }
        System.out.println();
        Console console = System.console();
        Scanner scn = new Scanner(System.in);

        System.out.print("username:");
        String username = scn.nextLine();
        System.out.println("---------------------------------------------------------");

        System.out.print("pass:");
        String pass = scn.nextLine();
        System.out.println("---------------------------------------------------------");

        System.out.print("host:");
        String host = scn.nextLine();
        System.out.println("---------------------------------------------------------");

        System.out.print("port:");
        int port = Integer.parseInt(scn.nextLine());
        System.out.println("-----------------------MEMORY USAGE-----------------------");
        MetricsReader reader = new MetricsReader();

        reader.execCommand("free -m",reader.sessionSSH(username,pass,host,port));
        System.out.println("-----------------------DISK USAGE-------------------------");

        reader.execCommand("df -h",reader.sessionSSH(username,pass,host,port));
    }


}
