package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Autonomous W/ Encoders Right")

public class AutoWithEncodersRight extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        ElapsedTime time = new ElapsedTime();

        Robot robot = new Robot(hardwareMap, time);

        Vision vision = new Vision(hardwareMap);

        double ticksPerIn = 40.887;
        double inchesPerBox = 21.375; // 24 for meet
        int id = 3;

        while (opModeInInit()) {
            id = vision.getIdentifier();
            telemetry.addData("Id:", id);
            telemetry.update();
        }

        if (id == -1) { id = 3; }

        waitForStart();



        robot.grabber.close();
        robot.sleep(0.5);
        robot.lift.setPosition(robot.lift.SMALL);

        robot.drive.forward().goDist(1);
        robot.sleep(0.5);

        robot.drive.left().goDist(inchesPerBox);
        robot.sleep(0.5);

        robot.drive.forward().goDist(2 * inchesPerBox);
        robot.sleep(0.5);

        robot.drive.right().goDist(0.5 * inchesPerBox + 1);
        robot.sleep(0.5);

        robot.lift.setPosition(robot.lift.LARGE);
        robot.sleep(0.5);

        robot.drive.forward().goDist(3);
        robot.sleep(0.5);

        robot.grabber.open();
        robot.sleep(0.5);

        robot.drive.backward().goDist(3);
        robot.sleep(0.5);

        robot.lift.setPosition(0);
        robot.sleep(0.5);

        if (id == 1) {
            robot.drive.left().goDist(5 * inchesPerBox);
            robot.sleep(0.5);
        }
        if (id == 2) {
            robot.drive.right().goDist(0.5 * inchesPerBox);
            robot.sleep(0.5);
        }
        if (id == 3) {
            robot.drive.right().goDist(1.5 * inchesPerBox);
            robot.sleep(0.5);
        }
    }
}