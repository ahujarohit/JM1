package com.vedisoft.jm1.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimitiveStreamExample {

	public static void main(String[] args) {
		int cityIdA = 1;
		String cityNameA = "Green Lake City";
		int cityPopulationA = 500000;
		float cityTempA = 15.50f;

		int cityIdB = 2;
		String cityNameB = "Salt Lake City";
		int cityPopulationB = 250000;
		float cityTempB = 10.45f;

		try (FileOutputStream fos = new FileOutputStream("cities.dat");
				DataOutputStream dos = new DataOutputStream(fos)) {

			dos.writeInt(cityIdA);
			dos.writeUTF(cityNameA);
			dos.writeInt(cityPopulationA);
			dos.writeFloat(cityTempA);

			dos.writeInt(cityIdB);
			dos.writeUTF(cityNameB);
			dos.writeInt(cityPopulationB);
			dos.writeFloat(cityTempB);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileInputStream fis = new FileInputStream("cities.dat"); 
				DataInputStream dis = new DataInputStream(fis)) {

			int cityId1 = dis.readInt();
			System.out.println("Id: " + cityId1);
			String cityName1 = dis.readUTF();
			System.out.println("Name: " + cityName1);
			int cityPopulation1 = dis.readInt();
			System.out.println("Population: " + cityPopulation1);
			float cityTemperature1 = dis.readFloat();
			System.out.println("Temperature: " + cityTemperature1);

			int cityId2 = dis.readInt();
			System.out.println("Id: " + cityId2);
			String cityName2 = dis.readUTF();
			System.out.println("Name: " + cityName2);
			int cityPopulation2 = dis.readInt();
			System.out.println("Population: " + cityPopulation2);
			float cityTemperature2 = dis.readFloat();
			System.out.println("Temperature: " + cityTemperature2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
