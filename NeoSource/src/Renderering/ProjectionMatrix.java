package Renderering;

import NeoMath.Matrixf;

class ProjectionMatrix{

    static Matrixf OrthographicProjectionMatrix(float near, float far, float top, float bottom, float left, float right)
    {
        Float[][] data = new Float[4][4];

        data[0][0] = 2 / (right-left);
        data[0][3] = -(right+left)/(right-left);

        data[1][1] = 2 / (top-bottom);
        data[1][3] = -(top+bottom)/(top-bottom);

        data[2][2] =- 2 / (far-near);
        data[2][3] =-(far+near)/(far-near);

        data[3][3] = 1f;

        return new Matrixf(data);
    }

    static Matrixf OrthographicProjectionMatrix(float width, float height, float near, float far)
    {
        Float right = width/2;
        Float left = width/2;

        Float top = height/2;
        Float bottom = height/2;

        Float[][] data = new Float[4][4];

        data[0][0] = 2 / (right-left);
        data[0][3] = -(right+left)/(right-left);

        data[1][1] = 2 / (top-bottom);
        data[1][3] = -(top+bottom)/(top-bottom);

        data[2][2] =- 2 / (far-near);
        data[2][3] =-(far+near)/(far-near);

        data[3][3] = 1f;

        return new Matrixf(data);
    }
}