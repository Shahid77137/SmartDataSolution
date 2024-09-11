package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main extends MemberFileConverter {

    @Override
    protected MemberExporter getMemberExporter() {
        // Create and return an instance of MemberExporterImpl
        return new MemberExporterImpl();
    }

    @Override
    protected MemberImporter getMemberImporter() {
        // Create and return an instance of MemberImporterImpl
        return new MemberImporterImpl();
    }

    @Override
    protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
        // Remove duplicates from the list of members
        Set<String> memberIds = new HashSet<>();
        List<Member> nonDuplicateMembers = new ArrayList<>();
        for (Member member : membersFromFile) {
            if (!memberIds.contains(member.getId())) {
                memberIds.add(member.getId());
                nonDuplicateMembers.add(member);
            }
        }
        return nonDuplicateMembers;
    }

    @Override
    protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
        // Split members by state
        Map<String, List<Member>> stateMemberMap = new HashMap<>();
        for (Member member : validMembers) {
            stateMemberMap.computeIfAbsent(member.getState(), k -> new ArrayList<>()).add(member);
        }
        return stateMemberMap;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.convertFile();
    }

    private void convertFile() {
        try {
            // Get the MemberImporter
            MemberImporter memberImporter = getMemberImporter();
            
            // Import members from a file
            File inputFile = new File("inputFile.csv"); // Assume input file is named "inputFile.csv"
            List<Member> membersFromFile = memberImporter.importMembers(inputFile);
            
            // Remove duplicate members
            List<Member> nonDuplicateMembers = getNonDuplicateMembers(membersFromFile);
            
            // Split members by state
            Map<String, List<Member>> stateMemberMap = splitMembersByState(nonDuplicateMembers);
            
            // Get the MemberExporter
            MemberExporter memberExporter = getMemberExporter();
            
            // Export members by state
            memberExporter.exportMembers(stateMemberMap);
            
            System.out.println("Member conversion and export completed successfully.");
        } catch (Exception e) {
            System.err.println("Error during file conversion: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

