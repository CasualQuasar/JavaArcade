package BrickClass;

import java.awt.Image;
import java.util.ArrayList;

import UI.SpriteSheet;

import java.awt.Color;
import java.awt.Graphics2D;

public class Alien extends Brick{

    int variant;
    public boolean canShoot;
    public boolean hasShot;
    Projectile projectile;

    public Alien(double x, double y, int width, int height, int variant)
    {
        super(x, y, width, height);
    }

    public Alien(double x, double y, int width, int height, int variant, Image img)
    {
        super(x, y, width, height, img);
    }

    public Alien(double x, double y, int width, int height, int variant, SpriteSheet ss)
    {
        super(x, y, width, height, ss);
    }

    public Alien(double x, double y, int width, int height, int variant, SpriteSheet ss, double dx, double dy)
    {
        super(x, y, width, height, ss, dx, dy);
    }

    public Alien(double x, double y, int width, int height, int variant, SpriteSheet ss, int dx, int dy)
    {
        super(x, y, width, height, ss, dx, dy);
    }

    public Alien(double x, double y, int width, int height, int variant, Color color) //Another constructor with optional values
    {
        super(x, y, width, height, color);
    }

    public Alien(double x, double y, int width, int height, int variant, Color color, int dx, int dy) //Another constructor with optional values
    {
        super(x, y, width, height, color, dx, dy);
    }

    public Alien(double x, double y, int width, int height, int variant, Color color, double dx, double dy) //Another constructor with optional values
    {
        super(x, y, width, height, color, dx, dy);
    }

    public Alien(double x, double y, int width, int height, int variant, Color color, int dx, int dy,
     int XMin, int XMax, int YMin, int YMax) //Another constructor with all values
    {
        super(x, y, width, height, color, dx, dy, XMin, XMax, YMin, YMax, null);
    }

    public Alien(double x, double y, int width, int height, int variant, Color color, double dx, double dy,
     int XMin, int XMax, int YMin, int YMax) //Another constructor with all values
    {
        super(x, y, width, height, color, dx, dy, XMin, XMax, YMin, YMax, null);
    }

    public Alien(double x, double y, int width, int height, int variant, Color color, double dx, double dy,
     int XMin, int XMax, int YMin, int YMax, Image img) //Another constructor with all values
    {
        super(x, y, width, height, color, dx, dy, XMin, XMax, YMin, YMax, img);
    }


    public int getVariant() {
        return this.variant;
    }

    public void setVariant(int variant) {
        this.variant = variant;
    }

    public boolean isCanShoot() {
        return this.canShoot;
    }

    public boolean getCanShoot() {
        return this.canShoot;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public boolean isHasShot() {
        return this.hasShot;
    }

    public boolean getHasShot() {
        return this.hasShot;
    }

    public void setHasShot(boolean hasShot) {
        this.hasShot = hasShot;
    }

    public void projectileChance(ArrayList<Projectile> projList, Projectile projectile)
    {
        int rand = (int) (Math.random() * 101 + 1);
        if (rand <= 10)
            shootProjectile(projList, projectile);

    }

    public void shootProjectile(ArrayList<Projectile> projList, Projectile proj)
    {
        if(!projList.contains(proj))
        {
            canShoot = true;  
            hasShot = false;
        }

        if(canShoot)
        {
        this.projectile = new Projectile(x + width/2, y + height, proj.getW(), proj.getH(), proj.getColor(),
        proj.getDx(), proj.getDy(), proj.getXMin(),  proj.getXMax(),  
        proj.getYMin(),  proj.getYMax());

        projList.add(projectile);
        hasShot = true;
        canShoot = false;
        }
    }

    public void updateProjectile()
    {  
        if(hasShot)
        projectile.update();

        if(projectile.getX() > projectile.getXMax() || projectile.getX() < projectile.getXMin() ||
            projectile.getY() > projectile.getYMax() || projectile.getY() < projectile.getYMin())
        {
            hasShot = false;
            projectile = null;
        }
    }

    public void drawProjectile(Graphics2D g2)
    {
        if(hasShot)
        projectile.draw(g2);
    }
}


