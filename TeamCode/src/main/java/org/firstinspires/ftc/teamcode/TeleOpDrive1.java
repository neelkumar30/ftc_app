package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "TeleOp Drive 1")
public class TeleOpDrive1 extends OpMode {

    DcMotor right_front;
    DcMotor right_back;
    DcMotor left_front;
    DcMotor left_back;
    float power = 0;
    float track = 0;


    @Override
    public void init() {

        right_front = hardwareMap.dcMotor.get("right_front");
        right_back = hardwareMap.dcMotor.get("right_back");
        left_front = hardwareMap.dcMotor.get("left_front");
        left_back = hardwareMap.dcMotor.get("left_back");
        left_front.setDirection(DcMotorSimple.Direction.REVERSE);
        left_back.setDirection(DcMotorSimple.Direction.REVERSE);


    }

    @Override
    public void loop() {

        float right_x = gamepad1.right_stick_x;
        float left_Y = gamepad1.left_stick_y;

        if (right_x < 0) {
            power = 1+right_x;
            right_front.setPower(left_Y);
            right_back.setPower(left_Y);
            left_front.setPower(left_Y * power);
            left_back.setPower(left_Y * power);
        }

        else if (right_x > 0) {
            power = 1 - right_x;
            right_front.setPower(left_Y * power);
            right_back.setPower(left_Y * power);
            left_front.setPower(left_Y);
            left_back.setPower(left_Y);
        }

        else{
            right_front.setPower(left_Y);
            right_back.setPower(left_Y );
            left_front.setPower(left_Y);
            left_back.setPower(left_Y);
        }


        telemetry.addData("Right Front Power", right_front.getPower());
        telemetry.addData("Right Back Power", right_back.getPower());
        telemetry.addData("Left Front Power", left_front.getPower());
        telemetry.addData("Left Back Power", left_back.getPower());

    }
}
