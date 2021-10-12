import java.time.LocalDate;
import java.util.List;

public class AdditionalFunctionality {

    public void checkIfInputExists(List<String> myList, String input) {
        if (myList.isEmpty()){
            System.out.println("List given is empty or invalid, try another.");
            System.exit(0);
        }

        userInputExist = false;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).contains(input)) {

                String extractMemberLastPaidDate = myList.get(i+1);
                this.membershipDate = LocalDate.parse(extractMemberLastPaidDate);

                String member = myList.get(i);
                int divideMemberInfo = member.indexOf(',');
                this.fullNameOfMember = member.substring(divideMemberInfo+2);
                this.personalIdentityNumber = member.substring(0, divideMemberInfo);

                divideMemberInfo = this.fullNameOfMember.indexOf(" ");
                this.memberFirstName = this.fullNameOfMember.substring(0, divideMemberInfo);
                this.memberLastName = this.fullNameOfMember.substring(divideMemberInfo+1);

                checkIfNameExistsMoreThanOnce(this.memberLastName, myList, input);
            }
        }
        if (!userInputExist){
            System.out.println("Not a member at the gym.");
        }

    }

    public void checkIfNameExistsMoreThanOnce(String memberLastName, List<String> myList, String input){
        int counter=0;
        if (input.equals(memberLastName)) {
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).contains(memberLastName)) {
                    counter++;
                }
            }
        }

        if (counter > 1) {
            System.out.println("There are two members with that name, please use ID number when searching.");
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).contains(memberLastName)) {
                    System.out.println(myList.get(i));
                }
            }
            System.exit(0);
        } else {
            validateMember(input);
        }

    }
}
