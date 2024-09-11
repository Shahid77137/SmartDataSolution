package com.smartdatasolutions.test;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

//import com.smartdatasolutions.test.impl.List;

public interface MemberExporter {

	public void writeMember( Member member, Writer writer ) throws IOException;

	void exportMembers(Map<String, List<Member>> stateMemberMap) throws IOException;

	void exportMembers1(Map<String, List<Member>> stateMemberMap) throws IOException;

}
