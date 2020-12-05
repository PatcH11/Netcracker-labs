package com.nc.lab1.csv;

import au.com.bytecode.opencsv.CSVReader;
import com.nc.lab1.entity.contract.Contract;
import com.nc.lab1.entity.contract.internet.InternetContract;
import com.nc.lab1.entity.contract.mobile.MobileContract;
import com.nc.lab1.entity.contract.tv.ChannelPackage;
import com.nc.lab1.entity.contract.tv.TvContract;
import com.nc.lab1.entity.person.Gender;
import com.nc.lab1.entity.person.Passport;
import com.nc.lab1.entity.person.Person;
import com.nc.lab1.repository.Repository;
import com.nc.lab1.validation.entity.contract.InternetContractValidate;
import com.nc.lab1.validation.entity.contract.MobileContractValidate;
import com.nc.lab1.validation.entity.contract.TvContractValidate;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Working with csv file.
 *
 * @author Nikolay Evsyukov
 * @version 1.1
 */
public class CsvReader {

    /**
     * Persons list.
     */
    private final List<Person> personList = new ArrayList<>();

    /**
     * Contract.
     */
    private Contract contract;

    /**
     * InternetContractValidate object.
     */
    private final InternetContractValidate internetContractValidate = new InternetContractValidate();

    /**
     * MobileContractValidate object.
     */
    private final MobileContractValidate mobileContractValidate = new MobileContractValidate();

    /**
     * TvContractValidate object.
     */
    private final TvContractValidate tvContractValidate = new TvContractValidate();

    /**
     * Populates the repository from a csv file.
     *
     * @param repository contract repository
     * @param file       csv file
     */
    public void filling(Repository<Contract> repository, File file) {
        try {
            CSVReader reader = new CSVReader(new FileReader(file), ';');
            String[] values;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            while ((values = reader.readNext()) != null) {
                CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
                String[] additionalInfo = csvParser.parseLine(values[13]);

                switch (values[12]) {
                    case "InternetContract":
                        contract = new InternetContract();
                        ((InternetContract) contract).setSpeedInternet(Double.parseDouble(additionalInfo[0]));
                        break;
                    case "MobileContract":
                        contract = new MobileContract();
                        ((MobileContract) contract).setMinutes(Integer.parseInt(additionalInfo[0]));
                        ((MobileContract) contract).setSms(Integer.parseInt(additionalInfo[1]));
                        ((MobileContract) contract).setTrafficInternet(Double.parseDouble(additionalInfo[2]));
                        break;
                    case "TvContract":
                        contract = new TvContract();
                        ((TvContract) contract).setChannelPackage(ChannelPackage.valueOf(additionalInfo[0]));
                        break;
                }

                contract.setId(Integer.parseInt(values[0]));
                contract.setStartOfContract(LocalDate.parse(values[1], formatter));
                contract.setEndOfContract(LocalDate.parse(values[2], formatter));
                contract.setContractNumber(values[3]);
                contract.setPerson(getPerson(new Person(Integer.parseInt(values[4]),
                        values[5],
                        values[6],
                        values[7],
                        LocalDate.parse(values[8], formatter),
                        Gender.valueOf(values[9]),
                        new Passport(Integer.parseInt(values[10]), Integer.parseInt(values[11]))
                )));

                if (contract instanceof InternetContract) {
                    if (internetContractValidate.isValid(internetContractValidate.validate((InternetContract) contract))) {
                        repository.add(contract);
                    }
                } else if (contract instanceof MobileContract) {
                    if (mobileContractValidate.isValid(mobileContractValidate.validate((MobileContract) contract))) {
                        repository.add(contract);
                    }
                } else if (contract instanceof TvContract) {
                    if (tvContractValidate.isValid(tvContractValidate.validate((TvContract) contract))) {
                        repository.add(contract);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the person.
     *
     * @param person person to check
     * @return person
     */
    public Person getPerson(Person person) {
        int i = checkPerson(person.getPassport());
        if (i == -1) {
            personList.add(person);
            return person;
        }
        return personList.get(i);
    }

    /**
     * Matching check.
     *
     * @param passport person's passport
     * @return repeating person
     */
    public int checkPerson(Passport passport) {
        if (personList.size() != 0) {
            for (int i = 0; i < personList.size(); i++) {
                if (passport.equals(personList.get(i).getPassport())) {
                    return i;
                }
            }
        }
        return -1;
    }
}
