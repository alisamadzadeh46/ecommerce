# Generated by Django 3.1.7 on 2021-04-01 20:37

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('home', '0021_price'),
    ]

    operations = [
        migrations.AlterField(
            model_name='price',
            name='create_at',
            field=models.DateField(auto_now_add=True),
        ),
        migrations.AlterField(
            model_name='price',
            name='update_at',
            field=models.DateField(auto_now=True),
        ),
    ]
