# Generated by Django 3.1.7 on 2021-03-31 10:36

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('home', '0013_auto_20210330_0033'),
    ]

    operations = [
        migrations.AddField(
            model_name='product',
            name='color',
            field=models.CharField(default=2, max_length=255, verbose_name='color'),
            preserve_default=False,
        ),
        migrations.AddField(
            model_name='product',
            name='warranty',
            field=models.FloatField(default=2),
            preserve_default=False,
        ),
    ]
