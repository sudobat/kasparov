# Jenkins Help


### Remote machine configuration

Run this commands in the remote machine in order to achieve the Jenkins build script to work.

Create the app structure:
``mkdir -p /home/ubuntu/apps/kasparov/jar_versions``

Copy the service file ``kasparov.service`` to path ``/etc/systemd/system/``

Reload daemon:
``sudo /bin/systemctl daemon-reload``

Enable the service:
``sudo systemctl enable kasparov.service``

Now the build script is ready to run